/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafiles;

/**
 *
 * @author Arsh
 */
public class UserModel {
    private int id = -1;
    private String full_name, email , phoneNo, userName , password, userDirectory ;
    //private String username;
    //private String userDirectory;
    
    public UserModel(){}
    public UserModel(int id, String full_name, String email, String phoneNo, String username , String password) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.userName = username;
        this.password = password;
    }
    public UserModel(String userDirectory){
        this.userDirectory = userDirectory;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String full_name) {
        this.full_name = full_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUserDirectory(String userDirectory){
        this.userDirectory = userDirectory;
    }
    public void setUsername(String username){
        this.userName = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNo;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    /*public String getuserDirectory(){
        return userDirectory;
    }*/

    public String getUsername() {
        
        return userName;
    }

    public String getUserDirectory() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return userDirectory;
    
    }
}
