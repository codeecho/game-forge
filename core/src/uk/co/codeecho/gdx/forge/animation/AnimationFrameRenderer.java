package uk.co.codeecho.gdx.forge.animation;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface AnimationFrameRenderer<M> {

    public void render(TextureRegion textureRegion, M model);
    
}
