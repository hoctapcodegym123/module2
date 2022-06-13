package Models;

import java.io.Serializable;

public class Account implements Serializable {
    private  String userName;
    private  String pass;
    private  String role;

    public Account() {
    }

    public Account(String userName, String pass, String role) {
        this.userName = userName;
        this.pass = pass;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account" +
                "userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' ;
    }
}

