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
import br.com.jogorogerio.jumper.elements.GameOver;
import br.com.jogorogerio.jumper.elements.Pipe;
import br.com.jogorogerio.jumper.elements.Pipes;
import br.com.jogorogerio.jumper.elements.Score;
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
    private Pipes pipes;
    private Score score;
    private GameOver gameover;
    private Context context;


    public Game(Context context) {
        super(context);
        this.context = context;
        screen = new Screen(context);
        startElements();
        setOnTouchListener(this);
    }

    private void startElements() {
        bird = new Bird(screen, context);
        score = new Score();
        pipes = new Pipes(screen, score, context);
        gameover = new GameOver(screen);
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
            bird.fall();

            bird.drawOnCanvas(canvas);
            pipes.drawOnCanvas(canvas);
            pipes.move();
            score.drawOnCanvas(canvas);

            if(new CollisionVerifier(bird, pipes).collided()) {
                isRunning = false;
                gameover.drawOnCanvas(canvas);
            }
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
