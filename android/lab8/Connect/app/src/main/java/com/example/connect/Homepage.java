package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {
    private ImageButton mbtnWebsite, mbtnCall, mbtnLocation, mbtnbtnMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mbtnWebsite = findViewById(R.id.btnWebsite);
        mbtnCall = findViewById(R.id.btnCall);
        mbtnLocation = findViewById(R.id.btnLocation);
        mbtnbtnMail = findViewById(R.id.btnMail);

        mbtnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Homepage.this, "Website button clicked.", Toast.LENGTH_SHORT).show();
                String url =  "http://newtreat.co.in/";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Homepage.this, "Call button clicked", Toast.LENGTH_SHORT).show();
                String contactNum =  "7619413700";

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactNum));

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Homepage.this, "Location button clicked", Toast.LENGTH_SHORT).show();
                String location =  "NewTreat.co";

                Uri addressUri = Uri.parse("geo:0,0?q=" + location);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        mbtnbtnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Homepage.this, "Mail button clicked", Toast.LENGTH_SHORT).show();
                String subject = "Greetings from 4MCA!!";
                String[] sendTo = new String[] {"dharamrajbhatt97@gmail.com", "mbharti321@gmail.com"};
                String content = "Hello!, This is a test email sent through the APP";

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, sendTo);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, content);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });
    }
}