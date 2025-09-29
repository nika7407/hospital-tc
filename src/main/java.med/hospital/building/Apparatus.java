package hospital.building;

public class Apparatus extends Equipment {

    private String description;
    private Department department;

    public Apparatus(String name, String description,
                     boolean inUse, Department department) {
        this.name = name;
        this.description = description;
        this.inUse = inUse;
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("apparat name:" + name)
                .append("\ndescription:" + description)
                .append("\nis in use:" + inUse)
                .append("\ndepartment:" + department);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Apparatus other = (Apparatus) obj;
        return other.name.equals(this.name)
                && other.department.equals(this.department);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.name);
    }
}
