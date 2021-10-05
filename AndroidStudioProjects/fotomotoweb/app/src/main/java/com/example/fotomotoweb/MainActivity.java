package com.example.fotomotoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton prtfls = (ImageButton)findViewById(R.id.btn_prtfl);
        ImageButton srvcs = (ImageButton)findViewById(R.id.btn_srvc);
        ImageButton ctcus = (ImageButton)findViewById(R.id.btn_cntc);
        ImageButton abtus = (ImageButton)findViewById(R.id.btn_abtus);

        //Button portfolio
        prtfls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_service class
                Intent intent = new Intent(MainActivity.this, activity_portfolio.class);
                startActivity(intent);
            }
        });

        //Button services
        srvcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_service class
                Intent intent = new Intent(MainActivity.this, activity_service.class);
                startActivity(intent);
            }
        });

        //Button contact us
        ctcus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_contact class
                Intent intent = new Intent(MainActivity.this, activity_contact.class);
                startActivity(intent);
            }
        });

        //Button about us
        abtus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_about class
                Intent intent = new Intent(MainActivity.this, activity_about.class);
                startActivity(intent);
            }
        });
    }
}