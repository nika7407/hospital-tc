package hospital.building;

public class Equipment {

    protected boolean InUse;
    protected String name;

    public boolean InUse() {
        return InUse;
    }

    public void setInUse(boolean inUse) {
        InUse = inUse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
