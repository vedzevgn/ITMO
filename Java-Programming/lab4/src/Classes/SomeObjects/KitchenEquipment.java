package Classes.SomeObjects;

import java.util.Objects;

public class KitchenEquipment extends Unnatural{
    private String name;

    public KitchenEquipment(String name) {
        this.name = name;
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
        KitchenEquipment that = (KitchenEquipment) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
