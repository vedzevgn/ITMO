package Classes.Locations;

import java.util.Objects;

public class UndefinedLoc extends Location{

    public UndefinedLoc(String name) {
        this.name = name;
    }

    private String name = "неизвестное место";
    Boolean isDangerous = Boolean.valueOf(true);

    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public boolean getIsDangerous(){
        return this.isDangerous;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + isDangerous.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UndefinedLoc undefinedLoc = (UndefinedLoc) o;
        return isDangerous == undefinedLoc.isDangerous && Objects.equals(name, undefinedLoc.name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
