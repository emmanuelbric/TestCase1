package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Display_Activity extends AppCompatActivity {

    TextView nameTextView, ageTextView, genderTextView, countryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        nameTextView = findViewById(R.id.textViewName);
        ageTextView = findViewById(R.id.textViewAge);
        genderTextView = findViewById(R.id.textViewGender);
        countryTextView = findViewById(R.id.country);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        String gender = intent.getStringExtra("gender");
        String country = intent.getStringExtra("country");

        nameTextView.setText("Name: " + name);
        ageTextView.setText("Age: " + age);
        genderTextView.setText("Gender:  Male" + gender);
        countryTextView.setText("Country: " + country);
    }
}
