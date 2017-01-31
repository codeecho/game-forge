package uk.co.codeecho.gdx.forge.box2d.body.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box2DMetaData {

    private String id;
    private String type;
    private List<String> attributes = new ArrayList<String>();
    private Map<String, Object> properties = new HashMap<String, Object>();
    private boolean markedForDestruction = false;

    public Box2DMetaData(String id) {
        this.id = id;
    }

    public Box2DMetaData(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public boolean hasAttribute(String attribute){
        return attributes.contains(attribute);
    }
    
    public void addAttribute(String attribute){
        attributes.add(attribute);
    }
    
    public void removeAttribute(String attribute){
        attributes.remove(attribute);
    }
    
    public boolean hasProperty(String name){
        return properties.containsKey(name);
    }
    
    public void setProperty(String name, Object value){
        properties.put(name, value);
    }
    
    public Object getProperty(String name){
        return properties.get(name);
    }
    
    public <V extends Object> V getProperty(String name, Class<? extends V> type){
        return (V) properties.get(name);
    }

    public boolean isMarkedForDestruction() {
        return markedForDestruction;
    }

    public void markForDestruction() {
        this.markedForDestruction = true;
    }
    
}
