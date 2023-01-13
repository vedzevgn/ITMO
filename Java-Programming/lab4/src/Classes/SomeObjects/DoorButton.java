package Classes.SomeObjects;

import java.util.Objects;

public class DoorButton extends Unnatural {


    private String name;

    public DoorButton(String name) {
        this.name = name;
    }

    private boolean isPressed = false;


    public void setPressed(boolean pressed) {
        this.isPressed = pressed;
        Door.rocketDoor.setOpened(true);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoorButton that = (DoorButton) o;
        return isPressed == that.isPressed && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, isPressed);
    }

    @Override
    public String toString() {
        return getName();
    }
}
