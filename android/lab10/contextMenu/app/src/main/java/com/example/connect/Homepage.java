package com.example.connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.BreakIterator;

public class Homepage extends AppCompatActivity {
    private ImageButton mbtnNainital, mbtnLaddakh, mbtnManali, mbtnbGokarna;
    int selectedImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        mbtnNainital = findViewById(R.id.btnNainital);
        mbtnLaddakh = findViewById(R.id.btnLaddakh);
        mbtnManali = findViewById(R.id.btnManali);
        mbtnbGokarna = findViewById(R.id.btnGokarna);


        registerForContextMenu(mbtnNainital);
        registerForContextMenu(mbtnLaddakh);
        registerForContextMenu(mbtnManali);
        registerForContextMenu(mbtnbGokarna);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
       // getMenuInflater().inflate(R.menu.contextmenu,menu);

        switch (v.getId()) {
            case R.id.btnNainital:
                selectedImage = R.id.btnNainital;
                getMenuInflater().inflate(R.menu.contextmenu, menu);
                return;

            case R.id.btnLaddakh:
                selectedImage = R.id.btnLaddakh;
                getMenuInflater().inflate(R.menu.contextmenu, menu);
                return;

            case R.id.btnManali:
                selectedImage = R.id.btnManali;
                getMenuInflater().inflate(R.menu.contextmenu, menu);
                return;

            case R.id.btnGokarna:
                selectedImage = R.id.btnGokarna;
                getMenuInflater().inflate(R.menu.contextmenu, menu);
                return;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id1:
                if (selectedImage == R.id.btnNainital) {
                    Toast.makeText(Homepage.this, "Redirecting to the website.", Toast.LENGTH_SHORT).show();
                    String url = "https://uttarakhandtourism.gov.in/destination/nainital/";
                    Uri webpage = Uri.parse(url);

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                    }

                }

                if (selectedImage == R.id.btnLaddakh) {
                    Toast.makeText(Homepage.this, "Redirecting to the website.", Toast.LENGTH_SHORT).show();
                    String url = "https://leh.nic.in/tourism/tourist-info/";
                    Uri webpage = Uri.parse(url);

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                    }

                }

                if (selectedImage == R.id.btnManali) {
                    Toast.makeText(Homepage.this, "Redirecting to the website.", Toast.LENGTH_SHORT).show();
                    String url = "https://himachaltourism.gov.in/destination/manali/";
                    Uri webpage = Uri.parse(url);

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                    }

                }

                if (selectedImage == R.id.btnGokarna) {
                    Toast.makeText(Homepage.this, "Redirecting to the website.", Toast.LENGTH_SHORT).show();
                    String url = "https://www.karnatakatourism.org/search-result/";
                    Uri webpage = Uri.parse(url);

                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d("ImplicitIntents", "Can't handle this intent!");
                    }

                }
            case R.id.id2:
                finish();
//                if(selectedImage == R.id.btnNainital){
//
//                }
//                if(selectedImage == R.id.btnLaddakh){
//
//                }
//                if(selectedImage == R.id.btnManali){
//
//                }
//                if(selectedImage == R.id.btnGokarna){
//
//                }

            }

        return super.onContextItemSelected(item);
    }

}