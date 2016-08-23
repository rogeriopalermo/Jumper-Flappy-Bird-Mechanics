package br.com.jogorogerio.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.jogorogerio.jumper.graphic.Screen;

/**
 * Created by Rogerio on 16/08/2016.
 */
public class Pipes {
    public static final int DISTANCE_BETWEEN_PIPES = 200;
    private final List<Pipe> pipes = new ArrayList<Pipe>();
    private final int PIPES_QUANTITY;
    private final Screen screen;
    private final Score score;
    private int maximum;
    private Context context;

    public Pipes(Screen screen, Score score, Context context) {
        int position = 400;
        PIPES_QUANTITY = 5;
        this.screen = screen;
        this.score = score;
        this.context = context;
        for (int i = 0; i < PIPES_QUANTITY; i++) {
            position += DISTANCE_BETWEEN_PIPES;
            Pipe pipe = new Pipe(screen, position, context);
            pipes.add(pipe);
        }
    }


    public void drawOnCanvas(Canvas canvas) {
        for (Pipe pipe : pipes) {
            pipe.drawOnCanvas(canvas);
        }
    }

    public void move() {
        ListIterator<Pipe> iterator = pipes.listIterator();
        while(iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.move();

            if (pipe.saiuDaTela()) {
                score.increase();
                iterator.remove();
                Pipe newPipe = new Pipe(screen, getMaximum() + DISTANCE_BETWEEN_PIPES, context);
                iterator.add(newPipe);
            }
        }
    }


    public int getMaximum() {
        int maximum = 0;
        for(Pipe pipe: pipes) {
            maximum = Math.max(pipe.getPosition(), maximum);
        }

        return maximum;
    }

    public boolean collidedWithBird(Bird bird) {
        for (Pipe pipe: pipes) {
            if(pipe.collidedHorizontallyWithBird(bird) && pipe.collidedVerticallyWithBird(bird)) {
                return true;
            }
        }
        return false;
    }
}
