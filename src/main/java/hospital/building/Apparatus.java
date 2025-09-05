package hospital.building;

public class Apparatus {

    private String name;
    private String description;
    private boolean isInUse;
    private Department department;

    public Apparatus(String name, String description,
                     boolean isInUse, Department department) {
        this.name = name;
        this.description = description;
        this.isInUse = isInUse;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
