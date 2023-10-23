package com.example.sockerito;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;


// Clase Ball para representar la pelota
public class Ball extends View {
    private float ballX = 1000;
    private float ballY = 450;
    private int colorRGB = 0xffff0000;
    private Paint paint;

    public Ball(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(colorRGB);
    }

    public void updatePosition(float x, float y) {
        // Actualizar la posición de la pelota en función de los valores del giroscopio
        ballX += x;
        ballY += y;
        //Toast.makeText(getContext(), "x: "+ballX+", y: "+ballY, Toast.LENGTH_SHORT).show();
        // Realizar detección y ajuste de colisiones aquí si es necesario

        // Solicitar una actualización de la vista
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius = 50;
        canvas.drawCircle(ballX, ballY, radius, paint);
    }

    public float getBallX() {
        return ballX;
    }

    public float getBallY() {
        return ballY;
    }

    public float getRadius() {
        return 50; // Tamaño del círculo
    }

    public void tope(boolean b,float valor) {// si es true es x de lo contratio es y

        if (b) {
            ballX = valor;

        } else {
            ballY = valor;
        }
        invalidate();

    }
}


