package com.example.fotomotoweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back);
        AppCompatButton prwd = (AppCompatButton) findViewById(R.id.btn_more_prw);
        AppCompatButton wd = (AppCompatButton)findViewById(R.id.btn_more_w);
        AppCompatButton evn = (AppCompatButton)findViewById(R.id.btn_more_ev);
        AppCompatButton mdl = (AppCompatButton)findViewById(R.id.btn_more_mdps);

        //Back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access MainActivity class
                Intent intent = new Intent(activity_service.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Button more prewedding
        prwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_prwedding class
                Intent intent = new Intent(activity_service.this, activity_prwedding.class);
                startActivity(intent);
            }
        });

        //Button more wedding
        wd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_wedding class
                Intent intent = new Intent(activity_service.this, activity_wedding.class);
                startActivity(intent);
            }
        });

        //Button more event
        evn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_model class
                Intent intent = new Intent(activity_service.this, activity_event.class);
                startActivity(intent);
            }
        });

        //Button more model
        mdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_model class
                Intent intent = new Intent(activity_service.this, activity_model.class);
                startActivity(intent);
            }
        });

    }
}