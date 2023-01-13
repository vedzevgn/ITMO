package Classes.Locations;

public class Rocket extends Location{
    public Rocket(String name) {
        this.name = name;
    }

    private String name;
    Boolean isDangerous = Boolean.FALSE;
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public boolean getIsDangerous(){
        return this.isDangerous;
    }

    public class RocketBack extends Rocket {

        private String name;

        public RocketBack(String name) {
            super(name);
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

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
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
