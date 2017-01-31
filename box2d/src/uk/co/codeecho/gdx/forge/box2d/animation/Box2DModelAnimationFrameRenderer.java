package uk.co.codeecho.gdx.forge.box2d.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import uk.co.codeecho.gdx.forge.animation.AnimationFrameRenderer;
import uk.co.codeecho.gdx.forge.box2d.Box2DModel;

public class Box2DModelAnimationFrameRenderer implements AnimationFrameRenderer<Box2DModel>{

    private Box2DAnimationFrameRenderer bodyAnimationRenderer;
    
    public Box2DModelAnimationFrameRenderer(SpriteBatch spriteBatch) {
        bodyAnimationRenderer = new Box2DAnimationFrameRenderer(spriteBatch);
    }

    @Override
    public void render(TextureRegion textureRegion, Box2DModel model) {
        bodyAnimationRenderer.render(textureRegion, model.getBody());
    }

}
