package Interfaces;

import Classes.Alives.Alive;
import Classes.SomeObjects.SomeObject;

public interface IDo {
    public String lose(Alive person, boolean isReturn);
    public String press(Alive person, SomeObject someObject, SomeObject whereIs, boolean isReturn);
    public String find(Alive firstPerson, Alive secondPerson, boolean isReturn);
    public String ensure(Alive firstPerson, Alive secondPerson, boolean isReturn);
    public String sleep(Alive person, boolean isReturn);
}
