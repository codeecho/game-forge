package uk.co.codeecho.gdx.forge.playground.player;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.library.mvc.View;
import uk.co.codeecho.gdx.forge.action.Action;
import uk.co.codeecho.gdx.forge.action.ActionManager;
import uk.co.codeecho.gdx.forge.action.SequentialAction;
import uk.co.codeecho.gdx.forge.component.IdentifiedComponent;
import uk.co.codeecho.gdx.forge.library.action.MoveToPositionAction;
import uk.co.codeecho.gdx.forge.playground.ball.Ball;

public class Player implements IdentifiedComponent, Renderable, Updatable{
    
    private final PlayerViewModel viewModel;
    private final View view;
    private final ActionManager actionManager;
    
    private final List<Action> actions = new LinkedList<Action>();
    
    private final float speed = 2;
    
    private Ball ball;

    public Player(PlayerViewModel viewModel, View view) {
        this.viewModel = viewModel;
        this.view = view;
        this.actionManager = new ActionManager();
    }
    
    public void addMoveAction(Vector2 position){
        addAction(new MoveToPositionAction(viewModel.getBody(), position, speed));
    }
    
    public void addThrowAction(final Vector2 target){
        addAction(new Action() {

            @Override
            public boolean invoke(float delta) {
                if(hasBall()){
                    Vector2 direction = new Vector2(target).sub(viewModel.getBody().getPosition()).nor();
                    Vector2 edgePosition = new Vector2(viewModel.getBody().getPosition()).add(new Vector2(direction).scl(viewModel.getRadius() + ball.getRadius()));
                    ball.setPosition(edgePosition);
                    ball.move(direction, 400);
                    releaseBall();
                }
                return true;
            }
        });
    }
    
    private void addAction(Action action){
        actions.add(action);
    }
    
    public void act(){
        actionManager.addAction(new SequentialAction(actions));
        actions.clear();
    }
    
    public void takeBall(Ball ball){
        this.ball = ball;
    }
    
    public boolean hasBall(){
        return ball != null;
    }
    
    public void releaseBall(){
        this.ball = null;
    }
    
    @Override
    public String getId() {
        return "player";
    }
    
    @Override
    public void update(float delta) {
        actionManager.update(delta);
        view.update(delta);
    }

    @Override
    public void render() {
        view.render();
    }
    
    public Body getBody(){
        return viewModel.getBody();
    }
    
}
