package uk.co.codeecho.gdx.forge.box2d.world;

import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.action.ContinuousAction;

public class WorldStepAction extends ContinuousAction {

    private World world;

    public WorldStepAction(World world) {
        this.world = world;
    }

    @Override
    public void doInvoke(float delta) {
        world.step(delta, 1, 1);
    }

}
