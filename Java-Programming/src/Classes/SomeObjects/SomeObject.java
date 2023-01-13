package Classes.SomeObjects;

import Classes.Alives.Alive;

public class SomeObject {
    private String name;

    public String getName(){
        return this.name;
    }


    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
