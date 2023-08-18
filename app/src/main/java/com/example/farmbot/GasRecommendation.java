package com.example.farmbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class GasRecommendation extends AppCompatActivity {

    String gas;
    TextView displayGas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_recommendation);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_humidity);
        lottieAnimationView.playAnimation();

        displayGas = findViewById(R.id.id_display_gas);


        Intent intent = getIntent();
        if(intent != null) {
            gas = intent.getStringExtra("gasData");
        }

        displayGas.setText(gas+" ppm");

    }
}