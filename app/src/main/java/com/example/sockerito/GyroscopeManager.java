package com.example.sockerito;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

// Clase GyroscopeManager para gestionar el giroscopio
public class GyroscopeManager implements SensorEventListener {
    private Sensor gyroscopeSensor;
    private SensorManager sensorManager;
    private Ball ball;
    CollisionManager collisionManager;

    public GyroscopeManager(Context context, Ball ball) {
        this.ball = ball;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensorManager.registerListener((SensorEventListener) this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        onResume();

    }

    protected void onResume() {
        collisionManager = new CollisionManager(ball);
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }


    protected void onPause() {
        // Pausar la escucha del acelerómetro al entrar en pausa o detener la actividad
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//            float x = 10 * ((event.values[0] < 0) ? -7 : 7);
//            float y = -10 * ((event.values[1] < 0) ? -7 : 7);
            int x = (int)event.values[1];
            int y = (int)event.values[0];

//            if(collisionManager.checkCollisions()){
//                onPause();
//            }
            // Actualizar la posición de la pelota en función de los valores del giroscopio
            ball.updatePosition(x, y);
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // Manejo de cambios de precisión del sensor
    }

    public void startListening() {
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stopListening() {
        sensorManager.unregisterListener(this);
    }
}
