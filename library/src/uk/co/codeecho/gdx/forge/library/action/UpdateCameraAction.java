package uk.co.codeecho.gdx.forge.library.action;

import com.badlogic.gdx.graphics.Camera;
import uk.co.codeecho.gdx.forge.action.ContinuousAction;

public class UpdateCameraAction extends ContinuousAction{

    private final Camera camera;

    public UpdateCameraAction(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void doInvoke(float delta) {
        camera.update();
    }
    
}
