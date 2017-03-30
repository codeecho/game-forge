package uk.co.codeecho.gdx.forge.component;

import java.util.LinkedList;

public class ComponentList<C extends Component> extends LinkedList<C>{

    public C getById(String id){
        for(C component: this){
            if(component instanceof IdentifiedComponent){
                IdentifiedComponent identifiedComponent = (IdentifiedComponent)component;
                if(id.equals(identifiedComponent.getId())){
                    return component;
                }
            }
        }
        return null;
    }
    
}
