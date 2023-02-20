package Converstion;

import core.Defaults;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import messangerdesignproject.*;

public class DataBaseOperation {
    
    public static boolean isRequestExist(String fromUniqueID, String toUniqueID){
        try {
            String query = "SELECT * FROM requests WHERE To_Request_ID = '"+ toUniqueID +"' AND From_Request_ID = '"+ fromUniqueID +"' AND Status = 'Requesting';";
            Connection myConn = MySQLConnection.getConnection();
            try {
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "List Users For Request Query Error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public static boolean isFrind(String FromuniqueID , String toUniqueID){
        try {
//            String query = "SELECT * FROM requests WHERE To_Request_ID = '"+ uniqueID +"' AND Status = 'Approved' ;";
 
            String query = "SELECT * FROM requests WHERE To_Request_ID = '"+ toUniqueID +"' AND From_Request_ID = '"+ FromuniqueID +"' AND Status = 'Approved';";
            
            Connection myConn = MySQLConnection.getConnection();
            try {
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "List Users For Request Query Error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public static boolean isRequestToApproved(String uniqueID){
        try {
            String query = "SELECT * FROM requests WHERE To_Request_ID = '"+ uniqueID +"' AND Status = 'Approved' ;";
            Connection myConn = MySQLConnection.getConnection();
            try {
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "List Users For Request Query Error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public static boolean isRequestFromApproved(String uniqueID){
        try {
            String query = "SELECT * FROM requests WHERE From_Request_ID = '"+ uniqueID +"' AND Status = 'Approved';";
            Connection myConn = MySQLConnection.getConnection();
            try {
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "List Users For Request Query Error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public static ArrayList<User> getUsers(String query, String type){
        ArrayList<User> usersList = new ArrayList<>();
        
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String status = null;
                String otherUID = null;
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {                        
                        if(type.equals("requests")){
                            status = resultSet.getString("Status");
                            otherUID = resultSet.getString("unique_id");
                            
//                            if (status == null) {
//                                if (isRequestExist(UserStats.unique_id, otherUID)) {   
//                                }else if(isRequestExist(otherUID, UserStats.unique_id)){
//                                }else{
                                    User user = new User(
                                            resultSet.getInt("UID"), 
                                            resultSet.getString("Username"), 
                                            resultSet.getString("Firstname"), 
                                            resultSet.getString("Lastname"), 
                                            otherUID,
                                            status
                                    );
                                    usersList.add(user);
//                                }
                         
                        }else if(type.equals("users")){
                            status = resultSet.getString("Status");
                            otherUID = resultSet.getString("unique_id");
                            if(status != null && status.equals("Approved")){
                                User user = new User(
                                        resultSet.getInt("UID"), 
                                        resultSet.getString("Username"), 
                                        resultSet.getString("Firstname"), 
                                        resultSet.getString("Lastname"), 
                                        otherUID,
                                        status
                                );
                                usersList.add(user);
                            }
//                            }else if (status.equals("Approved")) {
//                            }else if (status.equals("Requesting")) {
//                            }else if (status.equals("")){
//                            }
                        }
                                
//                        }else if(query.contains("")){
//                            User user = new User(
//                                    resultSet.getInt("UID"), 
//                                    resultSet.getString("Username"), 
//                                    resultSet.getString("Firstname"), 
//                                    resultSet.getString("Lastname"), 
//                                    resultSet.getString("unique_id"),
//                                    null
//                            );
//                            usersList.add(user);
//                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "List Users For Request Query Error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
        }
        
        return usersList;
    }
    
    public static ArrayList<Friend> getFriendList(){
        ArrayList<Friend> freindList = new ArrayList<>();

        String query = " SELECT * FROM Requests WHERE "
            + " To_Request_ID = '" + UserStats.unique_id + "'"
            + " OR "
            + " From_Request_ID = '" + UserStats.unique_id + "'"
            + " AND status = 'Approved';";

        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {                        
                        
                        Friend friend = new Friend(
                                resultSet.getString("From_Request_ID"), 
                                resultSet.getString("To_Request_ID"), 
                                resultSet.getString("From_Title"), 
                                resultSet.getString("To_Title"), 
                                resultSet.getString("From_Username"), 
                                resultSet.getString("To_Username"), 
                                resultSet.getString("Status") 
                        );
                        
                        freindList.add(friend);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return freindList;
    }
    
    public static boolean ifRequestToExists(String uniqueID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
            String query = "SELECT * FROM requests WHERE To_Request_ID = '"+ uniqueID+"'";
                
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return false;
    }
    
    public static boolean ifRequestFromExists(String uniqueID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
            String query = "SELECT * FROM requests WHERE From_Request_ID = '"+ uniqueID+"'";
                
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return false;
    }
    public static ArrayList<Requests> getRequests(){
        ArrayList<Requests> requestList = new ArrayList<>();
        
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "SELECT * FROM requests WHERE To_Request_ID = '"+UserStats.unique_id+"' AND status != 'Approved'";
                
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {
                        Requests requests = new Requests(
                                resultSet.getString("From_Request_ID"), 
                                resultSet.getString("To_Request_ID"), 
                                resultSet.getString("From_Title"), 
                                resultSet.getString("To_Title"), 
                                resultSet.getString("From_Username"), 
                                resultSet.getString("To_Username"), 
                                resultSet.getString("Status") 
                        );
                        requestList.add(requests);
                        
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return requestList;
    }
    
    public static void insertChat(String tableName , String FromUID, String toUID , String title, String message){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "INSERT INTO "+tableName+""
                        + "(FromUID,ToUID,Title,Message)VALUES(?,?,?,?)";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.setString(1, FromUID);
                preparedStatement.setString(2, toUID);
                preparedStatement.setString(3, title);
                preparedStatement.setString(4, message);
                
                preparedStatement.executeUpdate();
                System.out.println("Your Message has been sent successfully!");
                        
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
    }
            
    public static void editMessage(int UID, String tabelName , String message){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                
                String query = "UPDATE "+tabelName+" SET Message = ? WHERE UID = ?";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.setString(1, message);
                preparedStatement.setInt(2, UID);
                preparedStatement.executeUpdate();
                                        
                System.out.println("Message has been Edited seccessfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
    }

    public static void deleteMessage(int UID, String tabelName){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                
            String query = "DELETE FROM " + tabelName + " WHERE UID = "+UID;
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("Message deleted seccessfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
        
    }
    
    public static ArrayList<Converstion> converstions(String tableName){
        ArrayList<Converstion> usersList = new ArrayList<>();
        
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "SELECT * FROM " + tableName +"";
                
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {                        
                        
                        Converstion converstion = new Converstion(
                                resultSet.getInt("UID"), 
                                resultSet.getString("FromUID"), 
                                resultSet.getString("ToUID"), 
                                resultSet.getString("Title"), 
                                resultSet.getString("Message")
                        );
                        
                        usersList.add(converstion);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " + e.getMessage());
        }
        
        return usersList;
    }
    
    public static boolean isLogin(String userName, String password){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "SELECT * FROM users WHERE "
                        +" BINARY(Username) REGEXP '" + userName + "'" 
                        +" AND"
                        +" BINARY(Password) REGEXP '" + password + "';";
                
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {
                        UserStats.userID = resultSet.getInt("UID");
                        UserStats.userName = resultSet.getString("Username");
                        UserStats.firstName = resultSet.getString("Firstname");
                        UserStats.lastName = resultSet.getString("Lastname");
                        UserStats.unique_id = resultSet.getString("unique_id");
                        return true;
                    }
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return false;
    }
    
    public static void InsertUserRecord(String firstName, String lastName, String password
            ,String question_One, String question_Two, String answer_One, String answer_Two){
        
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String insert_into_users = "INSERT INTO users (Username,Password,Firstname,Lastname,unique_id)VALUES(?,?,?,?,?)";
                String insert_into_securety = "INSERT INTO Securety(Question_One,Question_Two,Answer_One,Answer_Two,unique_id)VALUES(?,?,?,?,?)";
                
                String unique_id = firstName+"_"+Defaults.generateID();
                System.out.println("Unique ID: " + unique_id);
                // Insert Into User:
                PreparedStatement preparedStatement = myConn.prepareStatement(insert_into_users);
                preparedStatement.setString(1, firstName +" "+ lastName);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, firstName);
                preparedStatement.setString(4, lastName);
                preparedStatement.setString(5, unique_id);
                preparedStatement.executeUpdate();
                // Insert Into User:

                // Insert Into Securety Question:
                PreparedStatement preparedStatement1 = myConn.prepareStatement(insert_into_securety);
                preparedStatement1.setString(1, question_One);
                preparedStatement1.setString(2, question_Two);
                preparedStatement1.setString(3, answer_One);
                preparedStatement1.setString(4, answer_Two);
                preparedStatement1.setString(5, unique_id);
                
                preparedStatement1.executeUpdate();
                // Insert Into Securety Question:
                
                JOptionPane.showMessageDialog(null, "Congrats Your account has been created successfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
    }
    
    public static boolean verifyUserAccount(String userName, String questionOne, String questionTwo, String answerOne, String answerTwo){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "SELECT"
                        +" users.Username,"
                        +" securety.Question_One,"
                        +" securety.Question_Two,"
                        +" securety.Answer_One,"
                        +" securety.Answer_Two"
                        +" FROM users JOIN securety WHERE"
                        +" users.Username = '"+userName+"'"
                        +" AND "
                        +" securety.Question_One = '"+questionOne+"'"
                        +" AND "
                        +" securety.Question_Two = '"+questionTwo+"'"
                        +" AND "
                        +" securety.Answer_One = '"+answerOne+"'"
                        +" AND "
                        +" securety.Answer_Two = '"+answerTwo+"'"
                        +" AND"
                        +" users.unique_id = securety.unique_id";
                                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {                        
                        System.out.println("User Exists From over DataBase!");
                        return true;
                    }
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return false;
    }

    public static String getUserUniqueID(String userName, String questionOne, String questionTwo, String answerOne, String answerTwo){
        String getUserUniqueID = "";
        
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "SELECT"
                        +" users.Username,"
                        +" users.unique_id,"
                        +" securety.Question_One,"
                        +" securety.Question_Two,"
                        +" securety.Answer_One,"
                        +" securety.Answer_Two"
                        +" FROM users JOIN securety WHERE"
                        +" users.Username = '"+userName+"'"
                        +" AND "
                        +" securety.Question_One = '"+questionOne+"'"
                        +" AND "
                        +" securety.Question_Two = '"+questionTwo+"'"
                        +" AND "
                        +" securety.Answer_One = '"+answerOne+"'"
                        +" AND "
                        +" securety.Answer_Two = '"+answerTwo+"'"
                        +" AND"
                        +" users.unique_id = securety.unique_id";
                                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if (resultSet.isBeforeFirst()) {
                    while (resultSet.next()) {                        
                        getUserUniqueID =  resultSet.getString("users.unique_id");
                    }
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
        return getUserUniqueID;
    }
    
    public static void createChatTable(String fromUID, String toUID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                
                String tableName = "chat_" + fromUID + "_" + toUID;
                
                String query = "CREATE TABLE " + tableName + "("
                        + " UID INT(255) NOT NULL AUTO_INCREMENT,"
                        + " FromUID VARCHAR(255),"
                        + " ToUID VARCHAR(255),"
                        + " Title VARCHAR(255),"
                        + " Message TEXT(255),"
                            + " PRIMARY KEY(UID)"+""
                        + ");";
                
                Statement statement = myConn.createStatement();
                statement.executeUpdate(query);

                System.out.println("Chat Created Between: " + tableName);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
    }
    
    public static boolean ifChatTableExists(String fromUID, String toUID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                
                String tableName = "chat_" + fromUID + "_" +toUID;
                
                String query = "SHOW TABLES LIKE '"+tableName+"'";
            
                Statement statement = myConn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                
                if (resultSet.isBeforeFirst()) {
                    return true;
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Chat Table Query: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
        
       return false;
    }
    
    public static void updateUserPassword(String userUniqueId, String userName, String password){
        
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "UPDATE users "
                        + "SET Password = '"+password+"'"
                        +" WHERE Username = '"+userName+"'"
                        +" AND "
                        +" unique_id = '" + userUniqueId + "' ";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Your Password has been Updated Successfully!"
                        + " \n please Remember Your Password: "+password
                );
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
        }
    }
    
    public static void sendRequest(String from_Username, String to_Username, String From_Request_ID, String To_Request_ID, String From_Title, String To_Title, String status){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "INSERT INTO Requests (From_Request_ID,To_Request_ID,From_Title,To_Title,From_Username, To_Username ,Status)VALUES(?,?,?,?,?,?,?)";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.setString(1, From_Request_ID);
                preparedStatement.setString(2, To_Request_ID);
                preparedStatement.setString(3, From_Title);
                preparedStatement.setString(4, To_Title);
                preparedStatement.setString(5, from_Username);
                preparedStatement.setString(6, to_Username);
                preparedStatement.setString(7, status);
                
                preparedStatement.executeUpdate();
                System.out.println("Request Sent successfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
        
    }
    
    public static void cancelRequest(String From_Request_ID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {

                String query = " DELETE FROM Requests WHERE From_Request_ID = '" + From_Request_ID + "' "
                        + " AND "
                        + " To_Request_ID = '" + UserStats.unique_id + "' ;";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("Request canceled successfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
    }
    
    public static void anFriend(String From_UniqueID, String To_UniqueID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {

                String query = " DELETE FROM Requests WHERE From_Request_ID = '" + From_UniqueID + "' "
                        + " AND "
                        + " To_Request_ID = '" + To_UniqueID + "' "
                        + " AND "
                        + " Status = 'Approved' ;" ;
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("UnFrined Successfully!!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
        
    }
    
    public static void cancelRequested(String From_Request_ID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {

                String query = " DELETE FROM Requests WHERE From_Request_ID = '" + UserStats.unique_id + "' "
                        + " AND "
                        + " To_Request_ID = '" + From_Request_ID + "' ; ";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("Request canceled successfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
    }
    
    public static void ApproveRequest(String From_Request_ID){
        try {
            Connection myConn = MySQLConnection.getConnection();
            try {
                String query = "UPDATE Requests SET Status = 'Approved' WHERE From_Request_ID = '" + From_Request_ID + "'"
                        + " AND "
                        + " To_Request_ID = '" + UserStats.unique_id + "' ; ";
                
                PreparedStatement preparedStatement = myConn.prepareStatement(query);
                preparedStatement.executeUpdate();
                
                System.out.println("Request Approved successfully!");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Query Error: " +e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error: " +e.getMessage());
        }
        
    }
}
