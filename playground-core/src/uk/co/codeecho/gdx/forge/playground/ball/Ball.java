package uk.co.codeecho.gdx.forge.playground.ball;

import com.badlogic.gdx.math.Vector2;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;
import uk.co.codeecho.gdx.forge.component.Component;

public class Ball implements Component{

    private final BallViewModel viewModel;

    public Ball(BallViewModel viewModel) {
        this.viewModel = viewModel;
        Box2DUtils.setComponent(viewModel.getBody(), this);
    }
    
    public void setPosition(Vector2 position){
        viewModel.getBody().setTransform(position, viewModel.getBody().getAngle());
    }
    
    public void move(Vector2 direction, float force){
        viewModel.getBody().applyForce(new Vector2(direction).nor().scl(force), viewModel.getBody().getPosition(), true);
    }

    public float getRadius() {
        return viewModel.getRadius();
    }
    
}
