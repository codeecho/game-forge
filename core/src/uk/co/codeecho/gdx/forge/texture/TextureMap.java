package uk.co.codeecho.gdx.forge.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.LinkedList;

public class TextureMap {

    private LinkedList<LinkedList<TextureRegion>> regions = new LinkedList<LinkedList<TextureRegion>>();

    public TextureMap() {
        
    }
    
    public void put(int x, int y, TextureRegion region){
        LinkedList<TextureRegion> column;
        if(regions.size() <= x){
            column = new LinkedList<TextureRegion>();
            regions.add(x, column);
        }else{
            column = regions.get(x);
        }
        for(int i=column.size(); i<y; i++){
            column.add(null);
        }
        column.add(y, region);
    }
    
    public TextureRegion get(int x, int y){
        LinkedList<TextureRegion> column = regions.get(x);
        if(column == null){
            return null;
        }
        return column.get(y);
    }
    
    public TextureMapParser from(int x, int y){
        return new TextureMapParser(this, x, y);
    }
    
}
