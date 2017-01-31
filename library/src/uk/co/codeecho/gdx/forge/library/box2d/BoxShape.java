package uk.co.codeecho.gdx.forge.library.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class BoxShape extends PolygonShape{

    public BoxShape(float width, float height) {
        setAsBox(width/2, height/2);
    }
    
    public BoxShape(float width, float height, Vector2 center){
        setAsBox(width/2, height/2, center, 0);
    }
}
