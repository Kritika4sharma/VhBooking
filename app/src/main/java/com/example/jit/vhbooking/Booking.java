package com.example.jit.vhbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.Iterator;
import java.util.List;

public class Booking extends AppCompatActivity {

    EditText rooms,guests,date,AC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        rooms = (EditText) findViewById(R.id.numroom);
        guests = (EditText) findViewById(R.id.numgst);
        date = (EditText) findViewById(R.id.date);
        AC = (EditText) findViewById(R.id.choice);
    }
    public Number atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (Number) result;
    }

    public void booknow(View view){


        final String d = date.getText().toString();
        final String ac = AC.getText().toString();
        final String g= guests.getText().toString();
        final String r = rooms.getText().toString();

        if(r==""){
            Toast.makeText(getApplicationContext(),"Atleast fill no.of rooms",Toast.LENGTH_LONG).show();
            Intent i = new Intent(Booking.this, MyAccount.class);
            startActivity(i);
            finish();
        }
        //Number  gg = atoi(g);
       // Number rr=atoi(r);
        //final String rr = r;
        //final int x=1;
        final ParseUser user = ParseUser.getCurrentUser();


        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereGreaterThan("rr", 0);
        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(List<ParseUser> objects, com.parse.ParseException e) {

                String c = "";
                int cc = 0;

                for (int i = 0;i<objects.size(); i++) {
                    c = objects.get(i).getString("rooms");
                    int num = Integer.parseInt(c);
                    cc += num;
                }

                int p = Integer.parseInt(r);    //  Integer.valueOf(r);

                if (cc + p > 30) {
                    user.put("Date", "0");
                    user.put("AC", "0");
                    user.put("guests", "0");
                    user.put("rooms", "0");
                    user.saveInBackground();
                } else {
                    user.put("Date", d);
                    user.put("AC", ac);
                    user.put("guests", g);
                    user.put("rooms", r);
                    user.saveInBackground();

                    //Toast.makeText(getApplicationContext(), " Rooms Booked!", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext()," Request Sent!!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Booking.this, MyAccount.class);
                startActivity(i);
                finish();

            }
        });


    }


}
