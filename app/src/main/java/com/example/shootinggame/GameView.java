package com.example.shootinggame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {

    private Game game;
    private double sceneWidth;
    private double sceneHeight;

    public GameView(Context context, Game game, int sceneWidth, int sceneHeight)
    {
        super(context);

        this.game = new Game();
        // set the game width and height
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    public void onDraw(Canvas canvas)
    {
        double birdX = game.getBirdX();
        double birdY = game.getBirdY();
        double bulletX = game.getBulletX();
        double bulletY = game.getBulletY();
        double gunX = game.getGunX();
        double gunY = game.getGunY();
        double radius = game.getRadius();

        Paint paint = new Paint();

        paint.setColor(Color.parseColor("#AAAAAA"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, (float)sceneWidth, (float)sceneHeight, paint);

        paint.setColor(Color.parseColor("#006600"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float)birdX, (float)(sceneHeight - birdY), (float)radius, paint);

        paint.setColor(Color.parseColor("#660000"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float)bulletX, (float)(sceneHeight - bulletY), (float)radius, paint);

        paint.setColor(Color.parseColor("#660000"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(30);
        canvas.drawLine(0, (float)sceneHeight, (float)gunX, (float)(sceneHeight - gunY), paint);
    }

}
