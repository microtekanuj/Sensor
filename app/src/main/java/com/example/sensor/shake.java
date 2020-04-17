package com.example.sensor;

import android.content.Intent;
import android.graphics.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class shake extends AppCompatActivity  implements SensorEventListener {
    SensorManager sensorManager;
    ImageView imageView;
    //private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        imageView=findViewById(R.id.image);
        sensorManager=(SensorManager)this.getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener((SensorEventListener)this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

    }
    //@Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float value[]=event.values;
            float x=value[0];
            float y=value[1];
            float z=value[2];
            float movement_shake=((x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH));
            if (movement_shake>=2)
            {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
                Toast.makeText(this, "Shake detected", Toast.LENGTH_SHORT).show();
                //Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
                //startActivity(intent);
            }
            else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
