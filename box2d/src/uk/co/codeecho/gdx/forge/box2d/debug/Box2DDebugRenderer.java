package uk.co.codeecho.gdx.forge.box2d.debug;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.component.Component;

public class Box2DDebugRenderer implements Component, Renderable {

    private final World world;
    private final OrthographicCamera camera;
    private final SpriteBatch spriteBatch;

    private final com.badlogic.gdx.physics.box2d.Box2DDebugRenderer debugRenderer;

    public Box2DDebugRenderer(World world, OrthographicCamera camera) {
        this(world, camera, null);
    }
    
    public Box2DDebugRenderer(World world, OrthographicCamera camera, SpriteBatch spriteBatch) {
        this.world = world;
        this.camera = camera;
        this.spriteBatch = spriteBatch;
        this.debugRenderer = new com.badlogic.gdx.physics.box2d.Box2DDebugRenderer();
    }

    @Override
    public void render() {
        if (spriteBatch != null) {
            spriteBatch.end();
        }
        debugRenderer.render(world, camera.combined);
        if (spriteBatch != null) {
            spriteBatch.begin();
        }
    }

}
