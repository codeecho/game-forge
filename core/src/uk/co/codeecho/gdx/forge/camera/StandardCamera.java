package uk.co.codeecho.gdx.forge.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import uk.co.codeecho.gdx.forge.GameManager;

public class StandardCamera extends OrthographicCamera{

    public StandardCamera() {
        super(GameManager.getInstance().getDisplayWidthInUnits(), GameManager.getInstance().getDisplayHeightInUnits());
        position.set(GameManager.getInstance().getDisplayWidthInUnits() / 2, GameManager.getInstance().getDisplayHeightInUnits() / 2, 0);
        update();
    }

}
