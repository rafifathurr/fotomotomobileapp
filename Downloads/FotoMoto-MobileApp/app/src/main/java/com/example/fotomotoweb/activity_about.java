package com.example.fotomotoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back);

        //Back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access MainActivity class
                Intent intent = new Intent(activity_about.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}