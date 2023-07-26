package com.example.farmbot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView temperature, humidity, moisture, ph, air;
    Button refreshBtn;
    String value;
    RetrofitClientInstance retrofitClientInstance = new RetrofitClientInstance();
    NodeMCUApiService nodeMCUApiService = retrofitClientInstance.getApiService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temperature = findViewById(R.id.TemperatureData);
        moisture = findViewById(R.id.MoistureData);
        ph = findViewById(R.id.PHData);
        air = findViewById(R.id.GasData);
        refreshBtn = findViewById(R.id.refreshID);
        humidity = findViewById(R.id.HumidityData);


        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMoisture();
            }
        });

    }


    private String getMoisture() {


        // Background work here
        // Make an API call
        Call<ModelClass> call = nodeMCUApiService.getDataFromNodeMCU();

        // UI Thread work here
        try {
            call.enqueue(new Callback<ModelClass>() {
                @Override
                public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        ModelClass data = response.body();
                        value = data.getSensorData();
                        if (value != null) {
                            String str2[] = value.split("\\s");
                            temperature.setText(str2[0]);
                            humidity.setText(str2[1]);
                            moisture.setText(str2[2]);
                            air.setText(str2[3]);
                            ph.setText(str2[4]);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "No data received", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ModelClass> call, Throwable t) {
                    Toast.makeText(MainActivity.this, " "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, " " + e, Toast.LENGTH_LONG).show();
        }


        return value;

    }


}