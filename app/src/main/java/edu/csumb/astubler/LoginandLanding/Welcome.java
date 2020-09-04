package edu.csumb.astubler.LoginandLanding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Anna Stubler
 * Title: Android Login and Landing page
 * @since 9/4/20
 * Abstract: This project creates a login and landing page.
 * This class displays a welcome message if the user logs in.
 */
public class Welcome extends AppCompatActivity {
    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        mUsername = intent.getStringExtra("username");
        String welcomeString = "Welcome " + mUsername;
        updateTextView(welcomeString);
    }

    public void updateTextView(String welcomeString) {
        TextView textView = (TextView) findViewById(R.id.welcome);
        textView.setText(welcomeString);
    }
}
