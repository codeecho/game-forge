package uk.co.codeecho.gdx.forge.texture;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureUtils {

    public TextureMap split(Texture texture, int columns, int rows){
        return split(texture, texture.getWidth()/columns, texture.getHeight()/rows, columns, rows);
    }
    
    public TextureMap split(Texture texture, int tileWidth, int tileHeight, int columns, int rows){
        TextureRegion[][] regions = TextureRegion.split(texture, tileWidth, tileHeight);
        TextureMap textureMap = new TextureMap();
        for(int i=regions.length-1; i>=0; i--){
            TextureRegion[] regionRow = regions[i];
            for(int j=0; j<regionRow.length; j++){
                textureMap.put(j, regions.length-1-i, regionRow[j]);
            }
        }
        return textureMap;
    }
    
}
