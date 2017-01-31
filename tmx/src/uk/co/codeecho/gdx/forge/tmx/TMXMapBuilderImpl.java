package uk.co.codeecho.gdx.forge.tmx;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.Method;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.component.Component;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilderFactory;
import uk.co.codeecho.gdx.forge.screen.ScreenLayer;

public class TMXMapBuilderImpl implements TMXMapBuilder {

    private final TiledMap tiledMap;
    private final OrthogonalTiledMapRenderer tiledMapRenderer;
    private final ComponentBuilderFactory factory;
    private final OrthographicCamera camera;

    public TMXMapBuilderImpl(TiledMap tiledMap, ComponentBuilderFactory factory, OrthographicCamera camera, SpriteBatch spriteBatch) {
        this.tiledMap = tiledMap;
        this.tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1 / GameManager.getInstance().getPixelsPerUnit(), spriteBatch);
        this.factory = factory;
        this.camera = camera;
    }

    @Override
    public List<ScreenLayer> build() {
        List<ScreenLayer> layers = new LinkedList<ScreenLayer>();
        for (MapLayer mapLayer : tiledMap.getLayers()) {
            List<Component> components = new LinkedList<Component>();
            MapProperties layerProperties = mapLayer.getProperties();
            String layerType = layerProperties.get("type", String.class);
            for (MapObject mapObject : mapLayer.getObjects()) {
                processMapObject(mapObject);
                MapProperties objectProperties = mapObject.getProperties();
                String objectType = objectProperties.get("type", String.class);
                if (objectType == null) {
                    objectType = layerType;
                }
                if (objectType != null) {
                    components.add(buildObject(objectType, objectProperties));
                }
            }
            ScreenLayer layer;
            if (mapLayer instanceof TiledMapTileLayer) {
                layer = new TMXTileLayer(mapLayer.getName(), camera, tiledMapRenderer, (TiledMapTileLayer) mapLayer);
            } else {
                layer = new ScreenLayer(mapLayer.getName());
            }
            layer.addComponents(components);
            layers.add(layer);
        }
        return layers;
    }

    protected void processMapObject(MapObject mapObject) {
        if (mapObject instanceof RectangleMapObject) {
            RectangleMapObject rectMapObject = (RectangleMapObject) mapObject;
            mapObject.getProperties().put("width", rectMapObject.getRectangle().getWidth());
            mapObject.getProperties().put("height", rectMapObject.getRectangle().getHeight());
        }
    }

    protected Component buildObject(String objectType, MapProperties properties) {
        ComponentBuilder builder = factory.getBuilder(objectType);
        properties.put("type", objectType);
        processBuilder(builder, properties);
        Component entity = builder.build();
        return entity;
    }

    protected void processBuilder(ComponentBuilder builder, MapProperties properties) {
        Iterator<String> keys = properties.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = properties.get(key);
            try {
                if(key.matches("x|y|width|height")){
                    float floatValue = (Float)value;
                    floatValue = GameManager.getInstance().pixelsToUnits(floatValue);
                    value = floatValue;
                }
                Method[] methods = ClassReflection.getMethods(builder.getClass());
                for(Method method: methods){
                    if(method.getName().equals("set" + key.substring(0, 1).toUpperCase() + key.substring(1))){
                        method.invoke(builder, value);
                    }
                }
            } catch (ReflectionException ex) {
                throw new IllegalStateException(ex);
            }
        }
    }

}
