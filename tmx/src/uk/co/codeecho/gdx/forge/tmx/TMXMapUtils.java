package uk.co.codeecho.gdx.forge.tmx;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import uk.co.codeecho.gdx.forge.GameManager;

public class TMXMapUtils {

    public static TMXMapProperties getMapProperties(TiledMap map){
        MapProperties mapProperties = map.getProperties();
        int tilesWide = mapProperties.get("width", Integer.class);
        int tilesHigh = mapProperties.get("height", Integer.class);
        int tileWidth = mapProperties.get("tilewidth", Integer.class);
        int tileHeight = mapProperties.get("tileheight", Integer.class);
        float width = GameManager.getInstance().pixelsToUnits(tilesWide * tileWidth);
        float height = GameManager.getInstance().pixelsToUnits(tilesHigh * tileHeight);
        return new TMXMapProperties(width, height);
    }
    
}
