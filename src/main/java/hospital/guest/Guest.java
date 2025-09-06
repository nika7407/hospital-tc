package hospital.guest;

public abstract class Guest {

    protected String guestId;
    protected String name;
    protected boolean isAllowed;

    public Guest(String guestId, String name, boolean isAllowed) {
        this.guestId = guestId;
        this.name = name;
        this.isAllowed = isAllowed;
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
        return isAllowed;
    }

    public void setAllowed(boolean allowed) {
        isAllowed = allowed;
    }

    protected abstract void checkIsAllowed();

}
