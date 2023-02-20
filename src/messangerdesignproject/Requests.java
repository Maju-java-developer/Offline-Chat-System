package messangerdesignproject;

public class Requests {
    
    String From_Request_ID, To_Request_ID, From_Title, To_Title, From_Username, To_Username, status;
    
    public Requests() {
    }

    public Requests(String From_Request_ID, String To_Request_ID, String From_Title, String To_Title, String From_Username, String To_Username, String status) {
        this.From_Request_ID = From_Request_ID;
        this.To_Request_ID = To_Request_ID;
        this.From_Title = From_Title;
        this.To_Title = To_Title;
        this.From_Username = From_Username;
        this.To_Username = To_Username;
        this.status = status;
    }

    public String getFrom_Request_ID() {
        return From_Request_ID;
    }

    public void setFrom_Request_ID(String From_Request_ID) {
        this.From_Request_ID = From_Request_ID;
    }

    public String getTo_Request_ID() {
        return To_Request_ID;
    }

    public void setTo_Request_ID(String To_Request_ID) {
        this.To_Request_ID = To_Request_ID;
    }

    public String getFrom_Title() {
        return From_Title;
    }

    public void setFrom_Title(String From_Title) {
        this.From_Title = From_Title;
    }

    public String getTo_Title() {
        return To_Title;
    }

    public void setTo_Title(String To_Title) {
        this.To_Title = To_Title;
    }

    public String getFrom_Username() {
        return From_Username;
    }

    public void setFrom_Username(String From_Username) {
        this.From_Username = From_Username;
    }

    public String getTo_Username() {
        return To_Username;
    }

    public void setTo_Username(String To_Username) {
        this.To_Username = To_Username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}