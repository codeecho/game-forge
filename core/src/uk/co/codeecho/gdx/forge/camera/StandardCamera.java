package uk.co.codeecho.gdx.forge.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class StandardCamera extends OrthographicCamera{

    public StandardCamera() {
        super(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        update();
    }

}
