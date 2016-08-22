package br.com.jogorogerio.jumper.engine;

import br.com.jogorogerio.jumper.elements.Bird;
import br.com.jogorogerio.jumper.elements.Pipes;

/**
 * Created by Rogerio on 22/08/2016.
 */
public class CollisionVerifier {

    private final Bird bird;
    private final Pipes pipes;

    public CollisionVerifier(Bird bird, Pipes pipes) {
        this.bird = bird;
        this.pipes = pipes;
    }


    public boolean collided() {
        return pipes.collidedWithBird(bird);
    }
}
