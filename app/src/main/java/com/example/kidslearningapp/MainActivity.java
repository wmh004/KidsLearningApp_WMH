package com.example.kidslearningapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.kidslearningapp.DB.ActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private Button BtnMathTest, BtnEnglishTest;
    private TextView TVDisplayMath, TVDisplayEnglish, TVTotalScore;
    private ActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Toolbar setup
        Toolbar toolbar = findViewById(R.id.TBMainAct);
        setSupportActionBar(toolbar);

        // Initialize View Model
        viewModel = new ViewModelProvider(this).get(ActivityViewModel.class);

        TVDisplayMath = findViewById(R.id.TVDisplayMath);
        viewModel.getMath().observe(this, score -> {
            if (score != null) {
                TVDisplayMath.setText("Math Score: " + score);
            }
        });

        TVDisplayEnglish = findViewById(R.id.TVDisplayEnglish);
        viewModel.getEnglish().observe(this, score -> {
            if (score != null) {
                TVDisplayEnglish.setText("English Score: " + score);
            }

        });

        TVTotalScore = findViewById(R.id.TVTotalScore);
        viewModel.getTotal().observe(this, score -> {
            if (score != null) {
                TVTotalScore.setText("Total Scores: " + score);
            }
        });

        BtnMathTest = findViewById(R.id.BtnMathTest);
        BtnMathTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mathTest = new Intent(MainActivity.this, MathActivity.class);
                startActivity(mathTest);
            }
        });

        BtnEnglishTest = findViewById(R.id.BtnEnglishTest);
        BtnEnglishTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent englishTest = new Intent(MainActivity.this, EnglishActivity.class);
                startActivity(englishTest);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}