package hospital.guest;

public abstract class Guest {

    protected String guestId;
    protected String name;
    protected boolean Allowed;

    public Guest(String guestId, String name, boolean isAllowed) {
        this.guestId = guestId;
        this.name = name;
        this.Allowed = isAllowed;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllowed() {
        return Allowed;
    }

    public void setAllowed(boolean allowed) {
        Allowed = allowed;
    }

    protected abstract void checkIsAllowed();

}
