package com.example.sockerito;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Ball extends View implements SensorEventListener {
    private Sensor gyroscopeSensor;
    private SensorManager sensorManager;
    private float ballx = 1000;
    private float bally = 450;
    private float speedx = 0;
    private float speedy = 0;
    private int colorRGB = 0xffff0000;
    public Ball(Context context) {
        super(context);
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float x = 10*((event.values[0]<0) ? -7: +7);
            float y = -10* ((event.values[1]<0) ? -7: +7);

            // Actualizar la velocidad de la pelota
            speedx += x ; // Ajusta el factor de velocidad según tu preferencia
            speedy += y ;


            // Mover la pelota en función de la velocidad
            ballx += speedx;
            bally += speedy;

            // Limitar la posición de la pelota dentro de la vista
            int maxX = getWidth()-50;
            int maxY = getHeight()-50;

            if (ballx < 50) {
                ballx = 50;
            } else if (ballx > maxX) {
                ballx = maxX;
            }

            if (bally < 50) {
                bally = 50;
            } else if (bally > maxY) {
                bally = maxY;
            }

            // Solicitar una actualización de la vista
            invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = 50; // Tamaño del círculo, ajusta según tu preferencia

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(colorRGB); // Cambia el color como desees

        canvas.drawCircle(ballx, bally, radius, paint);
    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sensorManager.unregisterListener(this);
    }
}
