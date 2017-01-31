package uk.co.codeecho.gdx.forge.library.camera;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Box2DBoundedTrackingCamera extends BoundedTrackingCamera{

    private Body target;
    
    public Box2DBoundedTrackingCamera(float viewportWidth, float viewportHeight, float xmin, float xmax, float ymin, float ymax, float scale, Body target) {
        super(viewportWidth, viewportHeight, xmin, xmax, ymin, ymax, scale);
        this.target = target;
    }

    public Body getTarget() {
        return target;
    }

    public void setTarget(Body target) {
        this.target = target;
    }

    @Override
    public Vector2 getTargetPosition() {
        if(target == null){
            return null;
        }
        return target.getPosition();
    }

}
