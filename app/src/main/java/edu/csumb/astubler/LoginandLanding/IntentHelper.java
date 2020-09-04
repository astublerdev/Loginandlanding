package edu.csumb.astubler.LoginandLanding;

import android.content.Context;
import android.content.Intent;

/**
 * @author Anna Stubler
 * Title: Android Login and Landing page
 * @since 9/4/20
 * Abstract: This project creates a login and landing page.
 * This class is a factory class for intents.
 */
public class IntentHelper {

    //used for intents without extras
    public static final Intent basicIntent(Context context, Class aClass) {
        return new Intent(context, aClass);
    }

    //used for the welcome page
    public static final Intent usernameIntent(Context context, Class aClass, String extra) {
        return new Intent(context, aClass).putExtra("username", extra);
    }
}
