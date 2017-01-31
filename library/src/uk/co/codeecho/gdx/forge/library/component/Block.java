package uk.co.codeecho.gdx.forge.library.component;

import com.badlogic.gdx.physics.box2d.Body;
import uk.co.codeecho.gdx.forge.component.Component;

public class Block implements Component{

    private final Body body;

    public Block(Body body) {
        this.body = body;
    }
    
}
