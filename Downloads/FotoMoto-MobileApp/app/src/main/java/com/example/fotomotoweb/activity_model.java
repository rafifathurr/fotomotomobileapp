package com.example.fotomotoweb;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import android.text.InputType;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.widget.ScrollView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DatabaseReference;
import com.example.fotomotoweb.model.data;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;


public class activity_model extends AppCompatActivity {
    DatePickerDialog picker;
    private DatabaseReference database;
    private EditText cust_name;
    private EditText cust_email;
    private EditText cust_phone;
    private EditText cust_subject;
    private EditText date_book;
    private EditText cust_additional;
    private String date_submit;
    private int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);

        key = new Random().nextInt(100001) + 20;

        LinearLayout form = (LinearLayout)findViewById(R.id.book_form);
        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back_srv);
        AppCompatButton btn_show = (AppCompatButton)findViewById(R.id.btn_show);
        AppCompatButton btn_book = (AppCompatButton)findViewById(R.id.btn_book);
        ScrollView scrlvw = findViewById(R.id.scrl);
        ImageSlider imageSlider = findViewById(R.id.slider);
        cust_name = (EditText)findViewById(R.id.ed_nama);
        cust_email = (EditText)findViewById(R.id.ed_email);
        cust_phone = (EditText)findViewById(R.id.ed_phone);
        cust_subject = (EditText)findViewById(R.id.ed_type);
        date_book = (EditText)findViewById(R.id.ed_date);
        cust_additional = (EditText)findViewById(R.id.ed_additional);

        cust_subject.setText("Model Photo Session");
        form.setVisibility(View.INVISIBLE);

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        date_submit = df.format(c);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.md1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.md2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.md3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        date_book.setInputType(InputType.TYPE_NULL);
        date_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(activity_model.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date_book.setText((monthOfYear + 1) + "/" + dayOfMonth  + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        //Back
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to Access activity_service class
                Intent intent = new Intent(activity_model.this, activity_service.class);
                startActivity(intent);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                form.setVisibility(View.VISIBLE);
                scrlvw.scrollTo(0, scrlvw.getBottom());

            }
        });

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fotomotoweb-default-rtdb.asia-southeast1.firebasedatabase.app/");
        //Adding Data
        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }
    public void save() {
        if(!isEmpty(cust_name.getText().toString()) && !isEmpty(cust_email.getText().toString()) &&
                !isEmpty(cust_phone.getText().toString()) && !isEmpty(cust_subject.getText().toString()) &&
                !isEmpty(date_book.getText().toString()) && !isEmpty(cust_additional.getText().toString()) &&
                !isEmpty(date_submit))
            submitBarang(new data(cust_name.getText().toString(),  cust_email.getText().toString(),
                    cust_phone.getText().toString(),  cust_subject.getText().toString(),
                    date_book.getText().toString(),  cust_additional.getText().toString(), date_submit));
        else
            Snackbar.make(findViewById(R.id.btn_book), "Please Input The Data First!", Snackbar.LENGTH_LONG).show();
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);  imm.hideSoftInputFromWindow(
                cust_name.getWindowToken(), 0);
    }

    private boolean isEmpty(String s) {
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void submitBarang(data data) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase  Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan  dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("booking").child(Integer.toString(key)).setValue(data).addOnSuccessListener(this, new  OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Snackbar.make(findViewById(R.id.btn_book), "Your Booking Success! Please Check Your Email!", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}