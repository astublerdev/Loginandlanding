package edu.csumb.astubler.LoginandLanding;

import android.content.Context;
import android.content.Intent;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.csumb.astubler.LoginandLanding.db.AppDatabase;
import edu.csumb.astubler.LoginandLanding.db.UserDAO;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private UserDAO mUserDAO;

    @Before
    public void setUp() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        mUserDAO = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DB_USER)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("edu.csumb.astubler.LoginandLanding", appContext.getPackageName());

        mUserDAO = Room.databaseBuilder(appContext, AppDatabase.class, AppDatabase.DB_USER)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }

    @Test
    public void testUsername() {
        User newUser = new User("username", "password");
        mUserDAO.insert(newUser);
        User retrieveUser = mUserDAO.getUserByUsername("username");
        assertEquals(newUser.getUserName(), retrieveUser.getUserName());
        assertNotEquals("abc", newUser.getUserName());
    }

    @Test
    public void testPassword() {
        User newUser = new User("username", "password");
        mUserDAO.insert(newUser);
        User retrieveUser = mUserDAO.getUserByUsername("username");
        assertEquals(newUser.getPassword(), retrieveUser.getPassword());
        assertNotEquals("abc", newUser.getPassword());
    }

    @Test
    public void testFactoryPattern() {
        Intent intent = IntentHelper.basicIntent(InstrumentationRegistry.getInstrumentation().getTargetContext(), LoginChecked.class);
        assertNotNull(intent);
        User newUser = new User("aUser", "password");
        Intent intent2 = IntentHelper.usernameIntent(InstrumentationRegistry.getInstrumentation().getTargetContext(), LoginChecked.class, newUser.getUserName());
        assertEquals(intent2.getStringExtra("username"), "aUser");
    }

}
