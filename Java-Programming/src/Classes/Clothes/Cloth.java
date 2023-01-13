package Classes.Clothes;

import Classes.Alives.Alive;

public class Cloth {
    private String name;

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    } /////непр

    @Override
    public String toString() {
        return getName();
    }
}
