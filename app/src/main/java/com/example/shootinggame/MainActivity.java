package com.example.shootinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Game game;
    private GameView gameView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialise variables
        game = new Game();

        gameView = new GameView(this, game);
        setContentView(gameView);


        // schedule a timer to execute a task (update the game interface)
        Timer timer = new Timer();
        GameTimerTask task = new GameTimerTask(game, gameView);
        timer.schedule(task, 5000, 20);

        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // when user touches this window, pass the event to the gesture detector
        gestureDetector.onTouchEvent(event);

        return true;
    }

    // gesture listener
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener{

        // when an a double tap gesture is triggered, fire the gun
        @Override
        public boolean onDoubleTap(MotionEvent e) {

            // fire gun
            game.fire();

            return super.onDoubleTap(e);
        }
    }
}
