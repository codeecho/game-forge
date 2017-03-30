package uk.co.codeecho.gdx.forge.library.action;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import uk.co.codeecho.gdx.forge.action.Action;
import uk.co.codeecho.gdx.forge.action.InitialisingAction;

public class MoveToPositionAction extends InitialisingAction {

    private final Body body;
    private final Vector2 destination;
    private final float speed;

    private Vector2 initialPosition;
    private float initialDistance;

    public MoveToPositionAction(Body body, Vector2 destination, float speed) {
        this.body = body;
        this.destination = destination;
        this.speed = speed;
    }

    @Override
    public void initialise() {
        initialPosition = new Vector2(body.getPosition());
        initialDistance = Math.abs(new Vector2(destination).sub(initialPosition).len());
    }

    @Override
    public boolean doInvoke(float delta) {
        Vector2 position = body.getPosition();
        if (Math.abs(new Vector2(position).sub(initialPosition).len()) >= initialDistance) {
            body.setLinearVelocity(0, 0);
            return true;
        }
        Vector2 velocity = new Vector2(destination).sub(position).nor().scl(speed);
        body.setLinearVelocity(velocity);
        return false;
    }

}
