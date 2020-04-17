package com.example.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    SensorEventListener listener;
    Sensor sensor;
    TextView t1;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.t1);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    public void onResume()
    {
       super.onResume();
       sensorManager.registerListener(lightListener,sensor,sensorManager.SENSOR_DELAY_NORMAL);

    }
    public void onStop()
    {
        super.onStop();
        sensorManager.unregisterListener(lightListener);
    }
    public SensorEventListener lightListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            t1.setText((int)x+" lux");

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}
