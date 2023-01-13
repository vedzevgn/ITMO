package Classes.SomeObjects;

import Classes.Alives.Alive;
import Classes.Alives.Person;
import Enums.FeelingsState;

public class Sun extends Natural {
    private final String name = "Солнце";

    public void burn(Person person){
        System.out.println("Солнышко припекало со страшной силой");
        person.setState(FeelingsState.HOT);
    }

    @Override
    public String getName(){
        return name;
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
    }

    @Override
    public String toString() {
        return getName();
    }

}
