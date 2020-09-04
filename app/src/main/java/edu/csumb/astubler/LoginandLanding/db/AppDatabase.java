package edu.csumb.astubler.LoginandLanding.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.csumb.astubler.LoginandLanding.User;

@Database(entities = {User.class, }, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_USER = "USER_TABLE";

    public abstract UserDAO getUserDAO();
}
