package br.com.jogorogerio.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.jogorogerio.jumper.graphic.CustomColors;
import br.com.jogorogerio.jumper.graphic.Screen;

/**
 * Created by Rogerio on 22/08/2016.
 */
public class GameOver {


    private final Screen screen;
    private final Paint TEXT_STYLE = CustomColors.getGameOverColor();

    public GameOver(Screen screen) {
        this.screen = screen;
    }

    public void drawOnCanvas(Canvas canvas) {
        String gameover = "Game Over";
        int horizontalCenter = centralizeText(gameover);
        canvas.drawText(gameover,horizontalCenter, screen.getHeight()/2, TEXT_STYLE);
    }

    private int centralizeText(String text) {
        Rect textLimit = new Rect();
        TEXT_STYLE.getTextBounds(text, 0, text.length(), textLimit);

        int horizontalCenter = screen.getWidth()/2- (textLimit.right - textLimit.left)/2;
        return horizontalCenter;
    }
}
