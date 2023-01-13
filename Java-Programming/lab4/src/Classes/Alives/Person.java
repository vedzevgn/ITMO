package Classes.Alives;

import Classes.Clothes.Boots;
import Classes.Locations.Location;
import Classes.SomeObjects.DoorButton;
import Classes.SomeObjects.Container;
import Classes.SomeObjects.KitchenEquipment;
import Classes.SomeObjects.SomeObject;
import Enums.FeelingsState;
import Enums.EnsureTypes;
import Exceptions.MissingContainerException;
import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class Person extends Alive {
    private String name;
    private FeelingsState currentFeelingsState;
    private Location currentLocation;
    private int personSpeed = 1;
    private float gluttony;
    private boolean isSatisfied;
    private int fatigue;

    Boolean isInDanger = Boolean.FALSE;
    Boolean levelOfFear = Boolean.TRUE;

    Boots boots = new Boots("космический сапожок");
    
    private interface foodInformation{
        float getGluttony();
        boolean getFoodSatisfaction();
    }
    


    public Person(String name, Location location, int gluttony, Boolean isSatisfied, int fatigue) {
        this.name = name;
        this.currentLocation = location;
        this.gluttony = gluttony;
        this.isSatisfied = isSatisfied;
        this.fatigue = fatigue;
    }

    public foodInformation getFoodInformation(){
        class personFoodInfo implements foodInformation {
            final float gluttony = Person.this.gluttony;
            final boolean isSatisfied = Person.this.isSatisfied;


            @Override
            public float getGluttony(){
                return this.gluttony;
            }
            @Override
            public boolean getFoodSatisfaction(){
                return this.isSatisfied;
            }

        }
        return new personFoodInfo();
    }

    public int getSpeed(){
        return personSpeed;
    }
    @Override
    public int getFatigue(){
        return fatigue;
    }
    public boolean getDanger(){
        return isInDanger;
    }
    @Override
    public boolean getFear(){
        return levelOfFear;
    }

    @Override
    public float getGluttony(){
        return gluttony;
    }

    public boolean getIsSatisfied(){
        return isSatisfied;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public Location getLocation(){
        return currentLocation;
    }
    

    public void setState(FeelingsState state){
        this.currentFeelingsState = state;
        if (currentFeelingsState == FeelingsState.HOT){
            this.personSpeed = 2;
        }
        if (currentFeelingsState != FeelingsState.HOT){
            this.personSpeed = 1;
        }
    }

    @Override
    public void setLocation(Location location){
        this.currentLocation = location;
    }

    public void setSpeed(int speed){
        this.personSpeed = speed;
    }
    public void setDanger(boolean isindanger){
        this.isInDanger = isindanger;
    }
    public void setFear(boolean leveloffear){
        this.levelOfFear = leveloffear;
    }
    public void setFatigue(int fatigue){
        this.fatigue = fatigue;
    }

    public String go(Person person, Location location, Boolean lowestSpeed, boolean isReturn) {
        if (lowestSpeed) {
            this.personSpeed = 1;
        }
        String returning = "";
        if(!isReturn) {
            if (this.personSpeed == 1) {
                System.out.println(person.getName() + " пошёл в " + location.getName());
            }
            if (this.personSpeed == 2) {
                System.out.println(person.getName() + " пустился бежать к " + location.getName());
                boots.setNumberOf(boots.getNumberOf() - 1);
            }
            if (boots.getNumberOf() == 0 && this.personSpeed > 1) {
                System.out.println(person.lose(person, false) + "второй " + boots.getName());
                this.personSpeed = 3;
                System.out.println(person.getName() + "(у/е) стало бежать легче");
            }
        }
        if (this.personSpeed == 1) {
            returning += person.getName() + " пошёл в " + location.getName();
        }
        if (this.personSpeed == 2) {
            returning += " пустился бежать к " + location.getName();
            boots.setNumberOf(boots.getNumberOf() - 1);
        }
        if (boots.getNumberOf() == 0 && this.personSpeed > 1) {
            returning += (person.lose(person, false) + "второй " + boots.getName() + "\n");
            this.personSpeed = 3;
            returning += person.getName() + "(у/е) стало бежать легче";
        }
        this.currentLocation = location;
        return returning;
    }
    @Override
    public String goesFrom(Alive person, Location location, boolean isReturn){
        if (!isReturn) {
            System.out.println((person.getName() + " вышел из " + location.getName()));
        }
        return person.getName() + " вышел из " + location.getName();
    }
    @Override
    public String goInto(Alive person, Location location, boolean isReturn){
        String returning = "";
        if(!isReturn) {
            System.out.println((person.getName() + " вошёл в " + location.getName()));
            if (location.getIsDangerous()) {
                System.out.println("В " + location.getName() + " " + person.getName() + " в опасности");
            } else {
                System.out.println("В " + location.getName() + " " + person.getName() + " в безопасности");
            }
        }
        if (location.getIsDangerous()) {
            returning += "В " + location.getName() + " " + person.getName() + " в опасности\n";
        } else {
            returning += "В " + location.getName() + " " + person.getName() + " в безопасности\n";
        }
        returning += person.getName() + " вошёл в " + location.getName();
        return returning;
    }

    public String fallThrough(Person person, Location location, boolean isReturn){
        if (!isReturn) {
            System.out.println(person.getName() + " провалился(-ась) сквозь " + location.getName());
            person.setLocation(location);
        }
        return person.getName() + " провалился(-ась) сквозь " + location.getName();
    }
    @Override
    public String lose(Alive person, boolean isReturn){
        return(person.getName() + " потерял ");
    }

    public void press(Alive person, DoorButton doorButton, Location location){
        System.out.println(person.getName() + " нажал " + doorButton.getName() + " в " + location);
        doorButton.setPressed(true);
    }

    public void find(Alive firstPerson, Alive secondPerson){
        if(secondPerson.getDanger() && firstPerson.getDanger()) {
            if (firstPerson.getFear()) {
                System.out.println(firstPerson.getName() + " не пошёл искать " + secondPerson.getName());
            } else {
                System.out.println(firstPerson.getName() + " начал искать " + secondPerson.getName());
            }
        } else {
            System.out.println(firstPerson.getName() + " оставил в опасности " + secondPerson.getName());
        }
    }
    @Override
    public void checkFear(Alive firstPerson){
        if(firstPerson.getFear()) {
            System.out.println(firstPerson.getName() + " страшно перепугался");
        } else {
            System.out.println(firstPerson.getName() + " не боится ");
        }
    }


    public void ensure(Person firstPerson, Person secondPerson, EnsureTypes type){
        firstPerson.setFatigue(firstPerson.getFatigue() + 1);
        if (type == EnsureTypes.NEARBY) {
            if (firstPerson.getLocation() != secondPerson.getLocation()) {
                System.out.println(firstPerson.getName() + " окликнул " + secondPerson.getName() + " и убедился, что " + secondPerson.getName() + " не рядом");
                firstPerson.setFear(true);
                firstPerson.checkFear(firstPerson);
                firstPerson.find(firstPerson, secondPerson);
            } else {
                System.out.println(secondPerson.getName() + " рядом с " + secondPerson.getName());
            }
        }
        if (type == EnsureTypes.FOOD){
            System.out.println(firstPerson.getName() + " проверил(-а) сытость " + secondPerson.getName());
            if (secondPerson.getFoodInformation().getFoodSatisfaction()) {
                System.out.println("Гибель от недостатка питания " + secondPerson.getName() + " пока не грозит, " + firstPerson.getName() + " успокоился");
            } else {
                System.out.println(secondPerson.getName() + " грозит гибель от недостатка питания, " + firstPerson.getName() + " начал волноваться");
            }
        }
        if(firstPerson.getFatigue() == 3){
            System.out.println("Рассчёты сильно утомили " + firstPerson.getName());
            sleep(firstPerson, false);
        }
        if(firstPerson.getFatigue() == 2){
            System.out.println("Рассчёты немного утомили " + firstPerson.getName());
        }
    }

    public void press(Alive person, SomeObject someObject, SomeObject whereIs){
        System.out.println(person.getName() + " нажал " + someObject.getName() + " в/на " + whereIs.getName());
    }

    public void foodCheckFor(Person firstPerson, Person secondPerson){
        if (secondPerson.getFoodInformation().getGluttony() != 1) {
            System.out.println(firstPerson.getName() + " неверно рассчитал(-a) запас еды для " + secondPerson.getName());
            System.out.println("На самом деле, еды для " + secondPerson.getName() + " хватит на " + (1.0 / (secondPerson.getFoodInformation().getGluttony())) + " лет с учётом его личных едовых качеств");
            if (secondPerson.getFoodInformation().getGluttony() > 1){
                System.out.println(secondPerson.getName() + " был не дурак покушать");
                System.out.println("Вся беда оказалась в том, что личные едовые качества " + secondPerson.getName() + " заключались в его чрезвычайной едовой недисциплинированности");
                if (secondPerson.getFoodInformation().getGluttony() > 1.5){
                    System.out.println(secondPerson.getName() + " может есть что угодно, где угодно, когда угодно и в каких угодно количествах");
                } else {
                    System.out.println(secondPerson.getName() + " может есть довольно много");
                }
            }
        } else {
            System.out.println("По расcчётам " + firstPerson.getName() + ", еды для " + secondPerson.getName() + " хватит на " + (1.0 / (secondPerson.getFoodInformation().getGluttony())) + " лет");
        }
    }

    public void ejectFrom(Person person, SomeObject[] ejectedFrom, SomeObject[] containers) throws MissingContainerException {
        if (containers.length != 0) {
            String ejectedFromWhat = "";
            for (int i = 0; i < ejectedFrom.length; i++) {
                if (i < ejectedFrom.length - 1) {
                    ejectedFromWhat = ejectedFromWhat + ejectedFrom[i] + ", ";
                } else {
                    ejectedFromWhat = ejectedFromWhat + ejectedFrom[i];
                }
            }

            String allContainers = "";
            for (int i = 0; i < containers.length; i++) {
                if (i < containers.length - 1) {
                    allContainers = allContainers + containers[i] + ", ";
                } else {
                    allContainers = allContainers + containers[i];
                }
            }
            System.out.println("Забравшись в " + person.getLocation() + ", " + person.getName() + " принялся уничтожать содержимое " + allContainers + " из " + ejectedFromWhat);
        } else {
            throw new MissingContainerException("Нельзя взять что-то из пустоты! Проверьте количество контейнеров.");
        }
    }

    public String sleep(Person person, boolean isReturn){
        if(!isReturn) {
            System.out.println(person.getName() + " погрузился(-ась) в сон");
        }
        this.fatigue = 0;
        return person.getName() + " погрузился(-ась) в сон";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return personSpeed == person.personSpeed && Objects.equals(name, person.name) && currentFeelingsState == person.currentFeelingsState && Objects.equals(currentLocation, person.currentLocation) && Objects.equals(isInDanger, person.isInDanger) && Objects.equals(levelOfFear, person.levelOfFear) && Objects.equals(boots, person.boots);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((currentLocation == null) ? 0 : currentLocation.hashCode());
        result = prime * result + ((currentFeelingsState == null) ? 0 : currentFeelingsState.hashCode());
        result = prime * result + levelOfFear.hashCode();
        result = prime * result + isInDanger.hashCode();
        result = prime * result + boots.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getName();
    }


}
