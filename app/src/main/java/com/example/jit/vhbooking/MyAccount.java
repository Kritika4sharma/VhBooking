package com.example.jit.vhbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
    }

    public void booking(View view){
        Intent i = new Intent(MyAccount.this, Booking.class);
        startActivity(i);
    }

    public void cancel(View view){
        ParseUser user = ParseUser.getCurrentUser();
        user.put("rooms","0");
        user.put("guests","0");
        user.put("AC","0");
        user.put("Date","0");
        user.saveInBackground();
        Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_LONG).show();
    }

    public void status(View view){
        ParseUser user = ParseUser.getCurrentUser();
        String s=user.getString("rooms");
        int num=Integer.parseInt(s);
        if(num>0){
            Toast.makeText(getApplicationContext(),num+" rooms booked",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"No rooms booked",Toast.LENGTH_LONG).show();
        }
    }

    public void logout(View view){
        Intent i = new Intent(MyAccount.this, Login.class);
        startActivity(i);
    }
}
