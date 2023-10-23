package com.example.sockerito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Ball ball;
    private GyroscopeManager gyroscopeManager;
    private CollisionManager collisionManager;
    Button play;
    private TextView coordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        coordinates = findViewById(R.id.coordinates);

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                play();
            }
        });


    }

    private void play() {
        play.setVisibility(View.GONE);

        ball = new Ball(this);
        RelativeLayout relativeLayoutball = findViewById(R.id.mainActiviity);
        relativeLayoutball.addView(ball);

        gyroscopeManager = new GyroscopeManager(this, ball);

    }
}