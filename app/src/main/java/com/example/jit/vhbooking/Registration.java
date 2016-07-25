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
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Registration extends AppCompatActivity {

    EditText etUsername2,etPassword2,etConPassword2,etEmail;
    String user_name,user_pass,user_conpass,user_email;
    Context ctx=this;
    Button bRegister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etUsername2=(EditText)findViewById(R.id.etUsername3);
        etPassword2=(EditText)findViewById(R.id.etPassword3);
        etConPassword2=(EditText)findViewById(R.id.etConPassword3);
        bRegister2=(Button)findViewById(R.id.bRegister3);
        etEmail=(EditText)findViewById(R.id.etEmail3);
    }

    public void signup(View view){
        user_name=etUsername2.getText().toString();
        user_pass=etPassword2.getText().toString();
        user_conpass=etConPassword2.getText().toString();
        user_email=etEmail.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(user_name);
        user.setPassword(user_pass);
        //user.setEmail(user_email);
        user.put("Date","");
        user.put("AC","");
        user.put("guests","");
        user.put("rooms","");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(),
                            "Successfully Signed up, please log in.",
                            Toast.LENGTH_LONG).show();
                    Intent in = new Intent(Registration.this, Login.class);
                    startActivity(in);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Sign up Error", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

}
