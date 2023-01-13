package Classes;

import Classes.Alives.Alive;

import java.lang.reflect.Method;
import java.util.Objects;

public class NotInText {
    private String name;

    public NotInText(String name) {
        this.name = name;
    }

    public void forgetPerson(Alive firstPerson, Alive secondPerson, String cause){
        System.out.print("Занявшись " + firstPerson.getName() + ", " + this.name + " позабыли о " + secondPerson.getName() + " во время того как: ");
        System.out.println(cause);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotInText notInText = (NotInText) o;
        return Objects.equals(name, notInText.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
