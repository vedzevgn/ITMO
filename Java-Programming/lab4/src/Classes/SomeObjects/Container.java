package Classes.SomeObjects;

import java.util.Objects;

public class Container extends Unnatural{
    private String name;

    public Container(String name) {
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
        Container container = (Container) o;
        return Objects.equals(name, container.name);
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
