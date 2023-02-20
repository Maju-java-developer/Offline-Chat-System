package Converstion;

public class Converstion {
    
    int UserID;
    String FromUID, toUID, Title,Message;
    
    public Converstion() {
    }

    public Converstion(int UserID, String FromUID, String toUID, String Title, String Message) {
        this.UserID = UserID;
        this.FromUID = FromUID;
        this.toUID = toUID;
        this.Title = Title;
        this.Message = Message;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUID(int UserID) {
        this.UserID = UserID;
    }

    public String getFromUID() {
        return FromUID;
    }

    public void setFromUID(String FromUID) {
        this.FromUID = FromUID;
    }

    public String getToUID() {
        return toUID;
    }

    public void setToUID(String toUID) {
        this.toUID = toUID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
}
