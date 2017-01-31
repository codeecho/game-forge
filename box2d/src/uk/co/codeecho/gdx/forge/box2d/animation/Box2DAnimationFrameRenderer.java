package uk.co.codeecho.gdx.forge.box2d.animation;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import net.dermetfan.gdx.physics.box2d.Box2DUtils;
import uk.co.codeecho.gdx.forge.animation.AnimationFrameRenderer;
import uk.co.codeecho.gdx.forge.util.CoordinateUtils;

public class Box2DAnimationFrameRenderer implements AnimationFrameRenderer<Body>{

    private final SpriteBatch spriteBatch;

    public Box2DAnimationFrameRenderer(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }
    
    @Override
    public void render(TextureRegion textureRegion, Body model) {
        Sprite sprite = new Sprite(textureRegion);
        sprite.setOriginCenter();
        sprite.setSize(Box2DUtils.width(model), Box2DUtils.height(model));
        sprite.setCenter(model.getPosition().x, model.getPosition().y);
        sprite.draw(spriteBatch);
    }

}
