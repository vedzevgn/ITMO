package Interfaces;

import Classes.Alives.Alive;
import Classes.Locations.Location;
import Classes.Clothes.Cloth;

public interface IGo {
    public String go(Alive person, Location location, boolean isReturn);
    public String goesFrom(Alive person, Location location, boolean isReturn);
    public String fallThrough(Alive person, Location location, boolean isReturn);
}
