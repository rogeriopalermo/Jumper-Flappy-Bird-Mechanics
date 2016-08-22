package br.com.jogorogerio.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import br.com.jogorogerio.jumper.graphic.CustomColors;

/**
 * Created by Rogerio on 22/08/2016.
 */
public class Score {

    public static final Paint WHITE = CustomColors.getScoreColor();
    private int points = 0;

    public void drawOnCanvas(Canvas canvas) {
        canvas.drawText(String.valueOf(points), 100, 100, WHITE);
    }


    public void increase() {
        points++;
    }
}
