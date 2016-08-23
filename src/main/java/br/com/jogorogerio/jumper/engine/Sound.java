package br.com.jogorogerio.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.jogorogerio.jumper.R;

/**
 * Created by Rogerio on 23/08/2016.
 */
public class Sound {

    private SoundPool sp;
    public static int JUMP;
    public static int POINTS;
    public static int COLLISION;

    public Sound(Context context) {
        sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        JUMP = sp.load(context, R.raw.pulo, 1);
        POINTS = sp.load(context, R.raw.pontos, 1);
        COLLISION = sp.load(context, R.raw.colisao, 1);
    }

    public void playMusic(int sound) {
        sp.play(sound, 1, 1, 1, 0, 1);
    }
}
