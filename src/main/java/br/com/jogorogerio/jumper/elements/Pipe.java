package br.com.jogorogerio.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.jogorogerio.jumper.R;
import br.com.jogorogerio.jumper.graphic.CustomColors;
import br.com.jogorogerio.jumper.graphic.Screen;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class Pipe {

    private static final Paint VERDE = CustomColors.getPipeColor();
    private int topPipeHeight;
    private int position;
    private int bottomPipeHeight;
    private Screen screen;
    private static final int PIPE_HEIGHT = 400;
    private static final int PIPE_WIDTH = 100;
    private Context context;
    private Bitmap bottomPipe;
    private Bitmap topPipe;

    public Pipe(Screen screen, int position, Context context) {
        this.screen = screen;
        this.position = position;
        bottomPipeHeight = screen.getHeight() - PIPE_HEIGHT - valorAleatorio();
        topPipeHeight = 0 + PIPE_HEIGHT + valorAleatorio();
        this.context = context;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);
        bottomPipe = Bitmap.createScaledBitmap(bp, PIPE_WIDTH, bottomPipeHeight, false);
        bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe2);
        topPipe = Bitmap.createScaledBitmap(bp, PIPE_WIDTH, topPipeHeight, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 400);
    }

    public void drawOnCanvas(Canvas canvas) {
        drawBottomPipe(canvas);
        drawTopPipe(canvas);
    }

    private void drawBottomPipe(Canvas canvas) {
        //canvas.drawRect( position , bottomPipeHeight, position + PIPE_WIDTH, screen.getHeight(), VERDE );

        canvas.drawBitmap(bottomPipe, position, bottomPipeHeight, null);
    }

    private void drawTopPipe(Canvas canvas) {
        //canvas.drawRect( position , 0, position + PIPE_WIDTH, topPipeHeight, VERDE );
        canvas.drawBitmap(topPipe, position, 0, null);

    }

    public void move() {
        this.position -= 5;
    }

    public boolean saiuDaTela() {
        return (position + PIPE_WIDTH) < 0;
    }

    public int getPosition() {
        return position;
    }

    public boolean collidedHorizontallyWithBird(Bird bird) {
        return this.position < bird.x + bird.RADIUS;
    }

    public boolean collidedVerticallyWithBird(Bird bird) {
        return bird.getHeight() - bird.RADIUS < this.topPipeHeight || bird.getHeight() + bird.RADIUS > this.bottomPipeHeight;
    }
}
