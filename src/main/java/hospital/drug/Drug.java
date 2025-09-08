package hospital.drug;

public class Drug {
    protected String name;
    //default state ALWAYS not aprroved by medics unitll proven otherwise
    protected boolean Aprroved = false;

    public Drug(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAprroved() {
        return Aprroved;
    }

    public void setAprroved(boolean aprroved) {
        Aprroved = aprroved;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("drug name:").append(name)
                .append("\nis approved:").append(Aprroved);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Drug otherDrug = (Drug) obj;
        return otherDrug.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.name);
    }

}
