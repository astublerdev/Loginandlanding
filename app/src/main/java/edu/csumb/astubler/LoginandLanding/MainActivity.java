package edu.csumb.astubler.LoginandLanding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import edu.csumb.astubler.LoginandLanding.db.AppDatabase;
import edu.csumb.astubler.LoginandLanding.db.UserDAO;

/**
 * @author Anna Stubler
 * Title: Android Login and Landing page
 * @since 9/4/20
 * Abstract: This project creates a login and landing page.
 */
public class MainActivity extends AppCompatActivity {

    UserDAO mUserDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDatabase();

        //check for users and add a default if there is none.
        List<User> users = mUserDAO.getAllUsers();
        if(users.size() <= 0) {
            User defaultUser = new User("din_djarin", "baby_yoda_ftw");
            mUserDAO.insert(defaultUser);
        }

        //using intent factory
        Intent intent = IntentHelper.basicIntent(getApplicationContext(), LoginChecked.class);
        startActivity(intent);

    }

    //sets up database
    private void getDatabase() {
        mUserDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_USER)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }
}
