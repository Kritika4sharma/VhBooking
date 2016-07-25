package com.example.jit.vhbooking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {


    Button bLogin;
    EditText etUsername,etPassword;
    TextView tvRegisterLink;
    String username,password;
    Context ctx=this;
    String usernametxt;
    String passwordtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUsername = (EditText) findViewById(R.id.etUsername);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
    }

    public void login(View view){
        usernametxt = etUsername.getText().toString();
        passwordtxt = etPassword.getText().toString();

        ParseUser.logInInBackground(usernametxt, passwordtxt,
                new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // If user exist and authenticated, send user to Welcome.class
                            Intent intent = new Intent(
                                    Login.this,
                                    MyAccount.class);


                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),
                                    "Successfully Logged in",
                                    Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "No such user exist, please signup",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void register(View view){

        Intent i = new Intent(Login.this, Registration.class);
        startActivity(i);
        finish();
    }
}
