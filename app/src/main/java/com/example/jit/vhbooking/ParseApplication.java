package com.example.jit.vhbooking;

    import android.app.Application;
    import android.os.Message;

    import com.parse.Parse;
    import com.parse.ParseACL;
    import com.parse.ParseObject;
    import com.parse.ParseUser;

public class ParseApplication extends Application {
        public static final String YOUR_APPLICATION_ID = "8uokxh0UoPpdOBURbCg9NtAN6WiIdG1K6orm7cst";
        public static final String YOUR_CLIENT_KEY = "UHETCSznfpTPrdUMDN8Y0lVRQ4FXMENHMlTLP9kO";
        @Override
        public void onCreate() {
            super.onCreate();
            Parse.enableLocalDatastore(this);
            Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

            ParseUser.enableAutomaticUser();
            ParseACL defaultACL = new ParseACL();

            // If you would like all objects to be private by default, remove this
            // line.
            defaultACL.setPublicReadAccess(true);

            ParseACL.setDefaultACL(defaultACL, true);
        }

    }

