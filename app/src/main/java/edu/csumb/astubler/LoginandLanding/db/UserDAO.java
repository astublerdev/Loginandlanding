package edu.csumb.astubler.LoginandLanding.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import java.util.List;

import edu.csumb.astubler.LoginandLanding.User;

/**
 * @author Anna Stubler
 * Title: Android Login and Landing page
 * @since 9/4/20
 * Abstract: This project creates a login and landing page.
 * This is the database for users.
 */
@Dao
public interface UserDAO {
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + AppDatabase.DB_USER)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.DB_USER + " WHERE mUsername = :username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDatabase.DB_USER + " WHERE mUserId = :userId")
    User getUserByUserId(int userId);
}
