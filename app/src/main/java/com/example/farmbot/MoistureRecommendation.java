package com.example.farmbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MoistureRecommendation extends AppCompatActivity {

    String moisture;
    TextView displayMoisture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moisture_recommendation);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_moisture);
        lottieAnimationView.playAnimation();

        displayMoisture = findViewById(R.id.id_display_moisture);


        Intent intent = getIntent();
        if(intent != null) {
            moisture = intent.getStringExtra("moisData");
        }

        displayMoisture.setText(moisture);

    }
}