package edu.csumb.astubler.LoginandLanding;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import edu.csumb.astubler.LoginandLanding.db.AppDatabase;

/**
 * @author Anna Stubler
 * Title: Android Login and Landing page
 * @since 9/4/20
 * Abstract: This project creates a login and landing page.
 * This class is for creating a user object.
 */
@Entity(tableName = AppDatabase.DB_USER)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int mUserId;
    private String mUserName;
    private String mPassword;

    public User(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
