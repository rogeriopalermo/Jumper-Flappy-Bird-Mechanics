package br.com.jogorogerio.jumper.elements;

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
    private int maximum;

    public Pipes(Screen screen) {
        int position = 400;
        PIPES_QUANTITY = 5;
        this.screen = screen;
        for (int i = 0; i < PIPES_QUANTITY; i++) {
            position += DISTANCE_BETWEEN_PIPES;
            Pipe pipe = new Pipe(screen, position);
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
                iterator.remove();
                Pipe newPipe = new Pipe(screen, getMaximum() + DISTANCE_BETWEEN_PIPES);
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
}
