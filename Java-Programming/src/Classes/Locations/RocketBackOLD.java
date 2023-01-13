package Classes.Locations;

public class RocketBackOLD extends Rocket{

    private String name;

    public RocketBackOLD(String name) {
        super(name);
        this.name = name;
    }

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
    }

    @Override
    public String toString() {
        return getName();
    }
}
