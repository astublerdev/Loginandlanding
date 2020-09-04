package edu.csumb.astubler.LoginandLanding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.csumb.astubler.LoginandLanding.db.AppDatabase;
import edu.csumb.astubler.LoginandLanding.db.UserDAO;

/**
 * @author Anna Stubler
 * Title: Android Login and Landing page
 * @since 9/4/20
 * Abstract: This project creates a login and landing page.
 * This class is where a user can login.
 */
public class LoginChecked extends AppCompatActivity {

    private EditText mUsernameField;
    private EditText mPasswordField;

    private Button loginButton;

    private UserDAO mUserDAO;

    private String mUsername;
    private String mPassword;

    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_checked);
        wireupDisplay();
        getDatabase();

    }

    private void wireupDisplay(){
        mUsernameField = findViewById(R.id.enterUsername);
        mPasswordField = findViewById(R.id.enterPassword);

        loginButton = findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //getting user input
                    getValuesFromDisplay();
                    //checking username
                    if (checkForUserInDatabase()) {
                        //checking password
                        if (!validatePassword()) {
                            Toast.makeText(LoginChecked.this, "Invalid password", Toast.LENGTH_SHORT).show();
                            //found at https://stackoverflow.com/questions/34647778/how-to-highlight-a-input-field-in-an-android-application-in-java
                            //highlight password
                            findViewById(R.id.enterPassword).requestFocus();
                        } else {
                            Intent intent = IntentHelper.usernameIntent(getApplicationContext(), Welcome.class, mUsername);
                            startActivity(intent);
                        }
                    }
                }
        });
    }

    private boolean validatePassword() {
        return mUser.getPassword().equals(mPassword);
    }

    private void getValuesFromDisplay() {
        mUsername = mUsernameField.getText().toString();
        mPassword = mPasswordField.getText().toString();
    }

    private boolean checkForUserInDatabase() {
        mUser = mUserDAO.getUserByUsername(mUsername);
        if (mUser == null) {
            Toast.makeText(this, "no " + mUsername + " found", Toast.LENGTH_SHORT).show();
            //found at https://stackoverflow.com/questions/34647778/how-to-highlight-a-input-field-in-an-android-application-in-java
            //highlight username
            findViewById(R.id.enterUsername).requestFocus();
            return false;
        }
        return true;
    }

    //setting up database
    private void getDatabase() {
        mUserDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_USER)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }
}

