package com.example.sockerito;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Porteria extends View {
    private float ball;
    private float ballY = 450;
    private int colorRGB = 0xff0000ff;
    private Paint paint;
    private int size;
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Porteria(Context context, int left, int top, int right, int bottom) {
        super(context);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(colorRGB);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Dibujar el rectángulo en el lienzo
        canvas.drawRect(left, top, right, bottom, paint);
    }

}
