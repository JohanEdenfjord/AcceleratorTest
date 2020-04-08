package com.example.acceleratortest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

//im not really using the accuracy in this application so its not applicable however i will make an empty method for it!

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView xAxis, yAxis, zAxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up a SensorManager and sensor (Accelerometer!)
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        assert sensorManager != null; // Android studio complained about getDefaultSensor and this was its automated fix!
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register the sensorListener to tell how often it will take a value from the sensor I think.
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign TextViews
        xAxis = (TextView) findViewById(R.id.xAxis);
        yAxis = (TextView) findViewById(R.id.yAxis);
        zAxis = (TextView) findViewById(R.id.zAxis);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        //will just put the values x, y and z on the screen
        //gravity is shown in the direction the phone is lying!
        xAxis.setText("X: " + event.values[0]);
        yAxis.setText("Y: " + event.values[1]);
        zAxis.setText("Z: " + event.values[2]);
        //in most sensors the setup is like and Array with the x, y and z values like so!
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Not in use! but I got an error if I did not have this method here!
    }
}
