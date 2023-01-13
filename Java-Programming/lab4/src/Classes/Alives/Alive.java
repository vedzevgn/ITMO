package Classes.Alives;

import Classes.Locations.Location;
import Classes.SomeObjects.SomeObject;
import Interfaces.IDo;
import Interfaces.IGo;

import java.util.Objects;

public class Alive implements IGo, IDo {

    private Location currentLocation;
    private String name;
    private float gluttony;
    private boolean isSatisfied;
    private int fatigue;

    Boolean levelOfFear = Boolean.TRUE;
    Boolean isInDanger = Boolean.FALSE;

    public boolean getDanger() {
        return isInDanger;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return currentLocation;
    }
    public float getGluttony(){
        return this.gluttony;
    }
    public boolean getFear() {
        return levelOfFear;
    }
    public Boolean getFoodSatisfaction(){
        return this.isSatisfied;
    }
    public int getFatigue(){
        return this.fatigue;
    }

    public void setLocation(Location location){
        this.currentLocation = location;
    }

    public String go(Alive person, Location location, boolean isReturn) {
        if(!isReturn) {
            System.out.println((person.getName() + " пошёл в " + location.getName()));
        }
        this.currentLocation = location;
        return person.getName() + " пошёл в " + location.getName();
    }

    public String goesFrom(Alive person, Location location, boolean isReturn) {
        if(!isReturn) {
            System.out.println(person.getName() + " вышел из " + location.getName());
        }
        return person.getName() + " вышел из " + location.getName();
    }

    public String goInto(Alive person, Location location, boolean isReturn) {
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
    public String lose(Alive person, boolean isReturn){
        return(person.getName() + " потерял ");
    }

    public String fallThrough(Alive person, Location location, boolean isReturn){
        if(!isReturn) {
            System.out.println(person.getName() + " провалился(-ась) сквозь " + location.getName());
        }
        return person.getName() + " провалился(-ась) сквозь " + location.getName();
    }

    public String press(Alive person, SomeObject someObject, SomeObject whereIs, boolean isReturn) {
        if(!isReturn) {
            System.out.println(person.getName() + " нажал " + someObject.getName() + " в/на " + whereIs.getName());
        }
        return person.getName() + " нажал " + someObject.getName() + " в/на " + whereIs.getName();
    }

    public String find(Alive firstPerson, Alive secondPerson, boolean isReturn) {
        if(!isReturn) {
            System.out.println(firstPerson.getName() + " начал искать " + secondPerson.getName());
        }
        return firstPerson.getName() + " начал искать " + secondPerson.getName();
    }

    public String ensure(Alive firstPerson, Alive secondPerson, boolean isReturn) {
        if (!isReturn) {
            if (firstPerson.getLocation() != secondPerson.getLocation()) {
                System.out.println(secondPerson.getName() + " не рядом с " + firstPerson.getName());
                firstPerson.find(firstPerson, secondPerson, false);
            } else {
                System.out.println(secondPerson.getName() + " рядом с " + secondPerson.getName());
            }
        }
        if (firstPerson.getLocation() != secondPerson.getLocation()) {
            return (secondPerson.getName() + " не рядом с " + firstPerson.getName());
        } else {
            return(secondPerson.getName() + " рядом с " + secondPerson.getName());
        }
    }

    public void checkFear(Alive firstPerson) {
        if (firstPerson.getFear()) {
            System.out.println(firstPerson.getName() + " испугался ");
        } else {
            System.out.println(firstPerson.getName() + " не боится ");
        }
    }


    public String sleep(Alive person, boolean isReturn){
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
        Alive alive = (Alive) o;
        return Float.compare(alive.gluttony, gluttony) == 0 && isSatisfied == alive.isSatisfied && fatigue == alive.fatigue && currentLocation.equals(alive.currentLocation) && name.equals(alive.name) && levelOfFear.equals(alive.levelOfFear) && isInDanger.equals(alive.isInDanger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLocation, name, gluttony, isSatisfied, fatigue, levelOfFear, isInDanger);
    }

    @Override
    public String toString() {
        return getName();
    }

}
