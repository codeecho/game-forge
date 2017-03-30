package uk.co.codeecho.gdx.forge.component;

import java.util.Collections;
import java.util.List;

public class CompositeComponent<C extends Component> implements Component{

    private final ComponentList<C> components;

    public CompositeComponent() {
        this.components = new ComponentList<C>();
    }
    
    public void addComponent(C component) {
        components.add(component);
    }

    public void addComponents(List<C> components) {
        for(C component: components){
            addComponent(component);
        }
    }

    public C getComponent(String id){
        return components.getById(id);
    }
    
    public List<C> getComponents(){
        return Collections.unmodifiableList(components);
    }
    
    

    
}
