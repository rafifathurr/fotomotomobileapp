package com.example.fotomotoweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class activity_portfolio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        ImageSlider imageSlider1 = findViewById(R.id.slider1);
        ImageSlider imageSlider2 = findViewById(R.id.slider2);
        ImageSlider imageSlider3 = findViewById(R.id.slider3);
        ImageSlider imageSlider4 = findViewById(R.id.slider4);
        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back);

        //Back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access MainActivity class
                Intent intent = new Intent(activity_portfolio.this, MainActivity.class);
                startActivity(intent);
            }
        });

        List<SlideModel> slideModels1 = new ArrayList<>();
        slideModels1.add(new SlideModel(R.drawable.prw1, ScaleTypes.FIT));
        slideModels1.add(new SlideModel(R.drawable.prw2, ScaleTypes.FIT));
        slideModels1.add(new SlideModel(R.drawable.prw3, ScaleTypes.FIT));
        imageSlider1.setImageList(slideModels1, ScaleTypes.FIT);

        List<SlideModel> slideModels2 = new ArrayList<>();
        slideModels2.add(new SlideModel(R.drawable.wd1, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable.wd2, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable.wd3, ScaleTypes.FIT));
        imageSlider2.setImageList(slideModels2, ScaleTypes.FIT);

        List<SlideModel> slideModels3 = new ArrayList<>();
        slideModels3.add(new SlideModel(R.drawable.ev1, ScaleTypes.FIT));
        slideModels3.add(new SlideModel(R.drawable.ev2, ScaleTypes.FIT));
        slideModels3.add(new SlideModel(R.drawable.ev3, ScaleTypes.FIT));
        imageSlider3.setImageList(slideModels3, ScaleTypes.FIT);

        List<SlideModel> slideModels4 = new ArrayList<>();
        slideModels4.add(new SlideModel(R.drawable.md1, ScaleTypes.FIT));
        slideModels4.add(new SlideModel(R.drawable.md2, ScaleTypes.FIT));
        slideModels4.add(new SlideModel(R.drawable.md3, ScaleTypes.FIT));
        imageSlider4.setImageList(slideModels4, ScaleTypes.FIT);
    }
}