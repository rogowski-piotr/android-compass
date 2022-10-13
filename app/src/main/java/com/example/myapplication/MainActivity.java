package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor magneticSensor;
    Sensor gravitySensor;
    Sensor accelerometerSensor;

    SensorEventListener listener;

    TextView textView1;
    TextView textView2;
    CompassView compassView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        compassView = (CompassView) findViewById(R.id.compassView);

        listener = new MySensorListener(sensorManager, textView1, textView2, compassView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (magneticSensor != null) {
            sensorManager.registerListener(listener, magneticSensor, SensorManager.SENSOR_DELAY_GAME);
        }
        if (gravitySensor != null) {
            sensorManager.registerListener(listener, gravitySensor, SensorManager.SENSOR_DELAY_GAME);
        }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(listener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }
}