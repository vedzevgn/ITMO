package Classes.Clothes;

import Classes.Alives.Alive;

public class Boots extends Cloth {


    private String name;
    public Boots(String name) {
        this.name = name;
    }
    private int numberOf = 1;

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
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
        Boots boots = (Boots) o;
        return numberOf == boots.numberOf && name.equals(boots.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + numberOf;
        return result;
    }



    @Override
    public String toString() {
        return getName();
    }
}
