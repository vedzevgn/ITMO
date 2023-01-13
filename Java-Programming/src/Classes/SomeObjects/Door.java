package Classes.SomeObjects;

import java.util.Objects;

public class Door{

    private String name = "Дверца шлюзовой камеры";

    DoorButton doorButton;
    public static Door rocketDoor;
    private Boolean isOpened = false;

    public Door(String name, DoorButton doorButton) {
        this.name = name;
        rocketDoor = this;
        this.doorButton = doorButton;
    }


    public void setOpened(boolean opened) {
        isOpened = opened;
        if (isOpened){
            System.out.println(this.name + " гостеприимно раскрылась");
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return Objects.equals(name, door.name) && Objects.equals(doorButton, door.doorButton) && Objects.equals(isOpened, door.isOpened);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, doorButton, isOpened);
    }

    @Override
    public String toString() {
        return getName();
    }
}
