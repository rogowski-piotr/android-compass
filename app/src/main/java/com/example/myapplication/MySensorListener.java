package com.example.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class MySensorListener implements SensorEventListener {

    float[] gravityValues = null;
    float[] accelerometerValues = null;
    float[] magneticFieldValues = null;

    SensorManager sensorManager;

    TextView textViewAccelerometer;
    TextView textViewOrientation;
    CompassView compassView;

    MySensorListener(SensorManager sensorManager, TextView textViewAccelerometer, TextView textViewOrientation, CompassView compassView) {
        this.sensorManager = sensorManager;
        this.textViewAccelerometer = textViewAccelerometer;
        this.textViewOrientation = textViewOrientation;
        this. compassView = compassView;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                gravityValues = sensorEvent.values.clone();
                break;

            case Sensor.TYPE_MAGNETIC_FIELD:
                magneticFieldValues = sensorEvent.values.clone();
                break;

            case Sensor.TYPE_ACCELEROMETER:
                accelerometerValues = sensorEvent.values.clone();
                double ax = accelerometerValues[0];
                double ay = accelerometerValues[1];
                double az = accelerometerValues[2];
                textViewAccelerometer.setText(String.format("ax: %.2f \n ay: %.2f \n az: %.2f", ax, ay, az));
                break;
        }

        if (gravityValues != null && magneticFieldValues != null) {
            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = sensorManager.getRotationMatrix(R, I, gravityValues, magneticFieldValues);
            if (success) {
                float orientation[] = new float[3];
                orientation = sensorManager.getOrientation(R, orientation);
                float azimuth = orientation[0];
                float pitch = orientation[1];
                float roll = orientation[2];

                float rotation = (float) (azimuth * 180 / 3.14159);
                compassView.updateRotation(rotation);
                compassView.invalidate();

                textViewOrientation.setText(String.format("azimuth: %.2f \n pitch: %.2f \n roll: %.2f \n rotation: %.2f", azimuth, pitch, roll, rotation));
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
