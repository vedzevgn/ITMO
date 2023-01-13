package Classes.Locations;

import java.util.Objects;

public class Cave extends Location{
    public Cave(String name) {
        this.name = name;
    }
    private String name;
    Boolean isDangerous = Boolean.TRUE;

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
        Cave cave = (Cave) o;
        return isDangerous == cave.isDangerous && Objects.equals(name, cave.name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
