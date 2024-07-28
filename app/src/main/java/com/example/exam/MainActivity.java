package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.nameedittext);
        EditText ageEditText = findViewById(R.id.ageedittext);
        RadioGroup genderRadioGroup = findViewById(R.id.gender);
        Spinner countrySpinner = findViewById(R.id.spinner);
        Button saveButton = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCountry = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                RadioButton checkedRadioButton = findViewById(genderRadioGroup.getCheckedRadioButtonId());
                String gender = "";
                if (checkedRadioButton != null) {
                    gender = checkedRadioButton.getText().toString();
                }
                String country = countrySpinner.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, Display_Activity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);
                intent.putExtra("gender", gender);
                intent.putExtra("country", country);
                startActivity(intent);
            }
        });
    }
}
