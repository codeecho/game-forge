package uk.co.codeecho.gdx.forge.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class TextureMapParser {

    private TextureMap textureMap;
    private int fromX;
    private int fromY;
    private int toX;
    private int toY;

    public TextureMapParser(TextureMap textureMap, int fromX, int fromY) {
        this.textureMap = textureMap;
        this.fromX = fromX;
        this.fromY = fromY;
    }
    
    public TextureMapParser to(int x, int y){
        toX = x;
        toY = y;
        return this;
    }
    
    public TextureMapParser by(int x, int y){
        toX = fromX + x;
        toY = fromY + y;
        return this;
    }
    
    public Array<TextureRegion> asArray(){
        Array<TextureRegion> array = new Array<TextureRegion>();
        for(int y=fromY; y<=toY; y++){
            for(int x=fromX; x<=toX; x++){
                array.add(textureMap.get(x, y));
            }
        }
        return array;
    }
    
    public TextureMap asMap(){
        TextureMap newMap = new TextureMap();
        for(int y=fromY; y<=toY; y++){
            for(int x=fromX; x<=toX; x++){
                newMap.put(x-fromX, y-fromY, textureMap.get(x, y));
            }
        }
        return newMap;
    }
    
}
