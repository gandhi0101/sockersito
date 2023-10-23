package com.example.sockerito;

import static android.opengl.ETC1.getHeight;
import static android.opengl.ETC1.getWidth;

import android.util.DisplayMetrics;
import android.widget.Toast;

// Clase CollisionManager para manejar las colisiones (implementa lógica según tus necesidades)
public class CollisionManager {
    private final int maxX;
    private final int maxY;
    private Ball ball;
    DisplayMetrics displayMetrics;

    public CollisionManager(Ball ball) {
        this.ball = ball;
        displayMetrics = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        maxX = 2300;
        maxY = 975;
    }

    public boolean checkCollisions() {
        boolean collided = false;
        //Toast.makeText(ball.getContext(), maxX+",  "+maxY, Toast.LENGTH_SHORT).show();

        if (ball.getBallX() < (ball.getRadius() + 100)) {
            ball.tope(true, (ball.getRadius() + 100));
            collided = true;
        }

        if (ball.getBallX() > maxX - (ball.getRadius() + 100)) {
            ball.tope(true, maxX - (ball.getRadius() + 100));
            collided = true;
        }
        if (ball.getBallY() < ball.getRadius()) {
            ball.tope(false, ball.getRadius());
            collided = true;
        }
        if (ball.getBallY() > maxY - ball.getRadius()) {
            ball.tope(false, maxY - ball.getRadius());
            collided = true;
        }

        return collided;
    }
}
