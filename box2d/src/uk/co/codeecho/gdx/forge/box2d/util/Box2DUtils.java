package uk.co.codeecho.gdx.forge.box2d.util;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import uk.co.codeecho.gdx.forge.box2d.body.builder.Box2DMetaData;
import uk.co.codeecho.gdx.forge.component.Component;

public class Box2DUtils extends net.dermetfan.gdx.physics.box2d.Box2DUtils{
    
    public static final String META_DATA_COMPONENT_KEY = "gdx-forge-component";
    
    public static Box2DMetaData getMetaData(Body body){
        return (Box2DMetaData) body.getUserData();
    }
    
    public static Box2DMetaData getMetaData(Fixture fixture){
        return (Box2DMetaData) fixture.getUserData();
    }
    
    public static void setComponent(Body body, Component component){
        getMetaData(body).setProperty(META_DATA_COMPONENT_KEY, component);
    }
    
    public static Component getComponent(Body body){
        return getMetaData(body).getProperty(META_DATA_COMPONENT_KEY, Component.class);
    }
    
    public static <T extends Component> T getComponent(Body body, Class<T> type){
        return getMetaData(body).getProperty(META_DATA_COMPONENT_KEY, type);
    }
    
}
