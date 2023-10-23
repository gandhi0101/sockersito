package com.example.sockerito;

import static android.opengl.ETC1.getHeight;
import static android.opengl.ETC1.getWidth;

import android.util.DisplayMetrics;
import android.widget.Toast;

// Clase CollisionManager para manejar las colisiones (implementa lógica según tus necesidades)
public class CollisionManager {
    private Ball ball;
    DisplayMetrics displayMetrics;
    public CollisionManager(Ball ball) {
        this.ball = ball;
        displayMetrics = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    public boolean checkCollisions() {
        // Lógica de detección y ajuste de colisiones

        int maxX = displayMetrics.widthPixels ;
        int maxY =  displayMetrics.heightPixels  ;


        if (ball.getBallX() < 50) {
            ball.tope(true, 50);
            return true;
        } else if (ball.getBallX() > maxX-50) {
            ball.tope(true, maxX);
            return true;
        }
        if (ball.getBallY() < 50) {
            ball.tope(false, 50);
            return true;
        } else if (ball.getBallY() > maxY-50) {
            ball.tope(false, maxY);
            return true;
        }
        return false;
    }
}
