package hospital.guest;

public abstract class Guest {

    protected String guestId;
    protected String name;
    protected boolean allowed;

    public Guest(String guestId, String name, boolean isAllowed) {
        this.guestId = guestId;
        this.name = name;
        this.allowed = isAllowed;
    }

    protected abstract void checkIsAllowed();

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
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        allowed = allowed;
    }
}
