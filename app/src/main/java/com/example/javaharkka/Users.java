/*
CiviVPlanner; Android Studio; Tommi Kunnari; Users.class;

This is the class that stores user information. It's stored
in the database and accessed seldomly.
*/

package com.example.javaharkka;

public class Users {
    public String userName;
    public String userEmail;

    public Users(){
    }

    public Users(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
