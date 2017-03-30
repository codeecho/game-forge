package uk.co.codeecho.gdx.forge.library.component;

import com.badlogic.gdx.physics.box2d.Body;
import uk.co.codeecho.gdx.forge.component.IdentifiedComponent;

public class Block implements IdentifiedComponent{

    private final Body body;
    
    private String id;

    public Block(Body body) {
        this.body = body;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
