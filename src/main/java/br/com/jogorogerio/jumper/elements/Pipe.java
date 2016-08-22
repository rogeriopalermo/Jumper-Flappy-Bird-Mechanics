package br.com.jogorogerio.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Toast;

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

    public Pipe(Screen screen, int position) {
        this.screen = screen;
        this.position = position;
        bottomPipeHeight = screen.getHeight() - PIPE_HEIGHT - valorAleatorio();
        topPipeHeight = 0 + PIPE_HEIGHT + valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 400);
    }

    public void drawOnCanvas(Canvas canvas) {
        drawBottomPipe(canvas);
        drawTopPipe(canvas);
    }

    private void drawBottomPipe(Canvas canvas) {
        canvas.drawRect( position , 0, position + PIPE_WIDTH, topPipeHeight, VERDE );

    }

    private void drawTopPipe(Canvas canvas) {
        canvas.drawRect( position , bottomPipeHeight, position + PIPE_WIDTH, screen.getHeight(), VERDE );

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
        return this.position < bird.x + bird.radius;
    }

    public boolean collidedVerticallyWithBird(Bird bird) {
        return bird.getHeight() - bird.radius < this.topPipeHeight || bird.getHeight() + bird.radius > this.bottomPipeHeight;
    }
}
