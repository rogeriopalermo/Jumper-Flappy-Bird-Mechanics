package br.com.jogorogerio.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.jogorogerio.jumper.R;
import br.com.jogorogerio.jumper.elements.Bird;
import br.com.jogorogerio.jumper.graphic.Screen;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener{

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Bird bird;
    private Bitmap back;
    private Screen screen;


    public Game(Context context) {
        super(context);
        screen = new Screen(context);
        startElements();
        setOnTouchListener(this);
    }

    private void startElements() {
        bird = new Bird();
        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        back = Bitmap.createScaledBitmap(background, screen.getWidth(), screen.getHeight(), false );
    }

    @Override
    public void run() {
        while(isRunning) {
            if(!holder.getSurface().isValid())
                continue;
            Canvas canvas = holder.lockCanvas();
            //drawing the game's components
            canvas.drawBitmap(back, 0, 0, null);
            bird.drawOnCanvas(canvas);
            bird.fall();
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void start() {
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        bird.jump();
        return false;
    }
}
