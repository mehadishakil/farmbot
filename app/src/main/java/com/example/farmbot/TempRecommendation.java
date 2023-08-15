package com.example.farmbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class TempRecommendation extends AppCompatActivity {

    private String temperature;
    TextView displayTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_recommandation);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_temperature);
        lottieAnimationView.playAnimation();

        displayTemperature = findViewById(R.id.id_display_temperature);


        Intent intent = getIntent();
        if(intent != null) {
            temperature = intent.getStringExtra("tempData");
        }



        if (!temperature.isEmpty()) {
            double celsius = Double.parseDouble(temperature);
            double fahrenheit = (celsius * 9 / 5) + 32;
            String formattedValues = String.format("%.2f°C / %.2f°F", celsius, fahrenheit);
            displayTemperature.setText(formattedValues);
        }



    }
}