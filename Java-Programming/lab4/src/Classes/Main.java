package Classes;

import Classes.Alives.Alive;
import Classes.Alives.Person;
import Classes.Clothes.Boots;
import Classes.Locations.*;
import Classes.SomeObjects.*;
import Enums.EnsureTypes;
import Exceptions.MissingContainerException;

public class Main {
    public static void main(String[] args) {
        NotInText readers = new NotInText("читатели");
        Sun sun = new Sun();
        DoorButton doorButton = new DoorButton("кнопка(у) двери");
        Door door = new Door("Дверца шлюзовой камеры", doorButton);
        Boots boots = new Boots("космический сапожок");
        Rocket rocket = new Rocket("ракета(у/е)");
        Rocket.RocketBack rocketBack = rocket.new RocketBack("хвостовая часть ракеты");
        Cave cave = new Cave("пещера");
        UndefinedLoc undefinedLoc = new UndefinedLoc("неизвестное место");
        MoonShell moonShell = new MoonShell("лунная оболочка");
        FoodCompartment foodCompartment = new FoodCompartment("пищевой отсек");
        Container[] containers = new Container[4];
        containers[0] = new Container("целлофановые и хлорвиниловые трубочки");
        containers[1] = new Container("тюбики");
        containers[2] = new Container("мешочки");
        containers[3] = new Container("пакетики");
        KitchenEquipment[] kitchenEquipments = new KitchenEquipment[3];
        kitchenEquipments[0] = new KitchenEquipment("термостаты");
        kitchenEquipments[1] = new KitchenEquipment("саморегулирующиеся космические духовые шкафы");
        kitchenEquipments[2] = new KitchenEquipment("холодильники");



        Person ponchik = new Person("Пончик", cave, 2, true, 0);
        Person neznayka = new Person("Незнайка", undefinedLoc, 1, true, 2);

        System.out.println(" ");
        ponchik.ensure(neznayka, ponchik, EnsureTypes.FOOD);
        System.out.println("\nГЛАВА ДВАДЦАТЬ ЧЕТВЁРТАЯ. ПРИКЛЮЧЕНИЯ ПОНЧИКА.");
        readers.forgetPerson(neznayka, ponchik, neznayka.fallThrough(neznayka, moonShell, true));
        ponchik.ensure(ponchik, neznayka, EnsureTypes.NEARBY);
        ponchik.goesFrom(ponchik, ponchik.getLocation(), false);
        ponchik.go(ponchik, rocket, false, false);
        sun.burn(ponchik);
        ponchik.go(ponchik, rocket, false, false);
        ponchik.press(ponchik, doorButton, rocketBack);
        ponchik.goInto(ponchik, rocket, false);
        ponchik.go(ponchik, foodCompartment, true, false);
        try {
            ponchik.ejectFrom(ponchik, kitchenEquipments, containers);
        } catch (MissingContainerException e){
            System.out.println(e.getMessage());
        }
        neznayka.foodCheckFor(neznayka, ponchik);

        }
}