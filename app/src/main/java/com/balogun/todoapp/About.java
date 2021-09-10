package com.balogun.todoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.balogun.todoappapp.R;

public class About extends AppCompatActivity {
    TextView email, phone, twitter, instagram;
    Button website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        twitter = (TextView) findViewById(R.id.twitter);
        instagram = (TextView) findViewById(R.id.instagram);
        website = (Button) findViewById(R.id.website);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain"); // send email as plain text
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hello@giftbalogun.name.ng"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Customer Contact");
                intent.putExtra(Intent.EXTRA_TEXT, "Write Your Message Here");
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+2347061601790"));
                startActivity(intent);

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/am_de_one"));
                startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/am_thd_one"));
                startActivity(intent);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://giftbalogun.name.ng/"));
                startActivity(intent);
            }
        });
    }

    public void closeabout(View view) {
        finish();
    }
}
