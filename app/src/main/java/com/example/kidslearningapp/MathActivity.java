package com.example.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.example.kidslearningapp.DB.ActivityViewModel;

public class MathActivity extends AppCompatActivity {

    private Button BtnSubmitMath;
    private RadioGroup RGQ1, RGQ2, RGQ3;
    private Integer count = 0;
    private ActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.TBMainAct);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24);
        }

        viewModel = new ViewModelProvider(this).get(ActivityViewModel.class);

        BtnSubmitMath = findViewById(R.id.BtnSubmitMath);

        // Set listeners for each RadioGroup
        RGQ1 = findViewById(R.id.RGQ1);
        RGQ1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

//                int selected = RGQ1.getCheckedRadioButtonId();
//                RadioButton demo = findViewById(checkedId);
//                String text = demo.getText().toString();

                if (checkedId == R.id.Q1option1) {
                    count++;
                }
            }
        });

        RGQ2 = findViewById(R.id.RGQ2);
        RGQ2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.Q2option2) {
                    count++;
                }
            }
        });

        RGQ3 = findViewById(R.id.RGQ3);
        RGQ3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.Q3option1) {
                    count++;
                }
            }
        });

        BtnSubmitMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.updateMath(count);

                Toast.makeText(MathActivity.this, "Your Math score: " + count, Toast.LENGTH_LONG).show();

                Intent back = new Intent(MathActivity.this, MainActivity.class);
                startActivity(back);
            }
        });
    }

    // Handle Up button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
