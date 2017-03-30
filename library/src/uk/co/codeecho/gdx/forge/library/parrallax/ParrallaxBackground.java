package uk.co.codeecho.gdx.forge.library.parrallax;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.component.Component;

public class ParrallaxBackground implements Component, Renderable{

    private Camera camera;
    private SpriteBatch spriteBatch;
    private Texture texture;
    private float width;
    private float height;
    private float scale;
    
    private float textureWidth;
    private float textureHeight;
    private int horizontalTiles;

    private Vector2 previousPosition;
    private Vector3 previousCameraPosition;

    public ParrallaxBackground(Camera camera, SpriteBatch spriteBatch, Texture texture, float width, float height, float scale, boolean fitWidth, boolean fitHeight) {
        this.camera = camera;
        this.spriteBatch = spriteBatch;
        this.texture = texture;
        this.texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        this.width = width;
        this.height = height;
        this.scale = scale;
        if(fitWidth && fitHeight){
            textureWidth = width;
            textureHeight = height;
        }else if(fitWidth){
            textureWidth = width;
            textureHeight = texture.getHeight() * (width/texture.getWidth());
        }else if(fitHeight){
            textureHeight = height;
            textureWidth = texture.getWidth() * (height/texture.getHeight());
        }else{
            textureWidth = texture.getWidth();
            textureHeight = texture.getHeight();
        }
        horizontalTiles = (int)(width / textureWidth) + 1;
    }

    @Override
    public void render() {
        
        Vector3 cameraPosition = camera.position;
        if (previousCameraPosition == null) {
            cameraPosition = new Vector3(0, 0, 0);
            previousPosition = new Vector2(0, 0);
            previousCameraPosition = new Vector3(0, 0, 0);
        }
        float cameraDeltaX = cameraPosition.x - previousCameraPosition.x;
        float cameraDeltaY = cameraPosition.y - previousCameraPosition.y;
        float deltaX = cameraDeltaX * scale;
        float deltaY = cameraDeltaY * scale;
        float newX = previousPosition.x + deltaX;
        float newY = previousPosition.y + deltaY;
        for(int i=0; i<horizontalTiles; i++){
            spriteBatch.draw(texture, newX+(textureWidth*i), newY, textureWidth, textureHeight);
        }
        previousPosition = new Vector2(newX, newY);
        previousCameraPosition = new Vector3(camera.position);
    }

}
