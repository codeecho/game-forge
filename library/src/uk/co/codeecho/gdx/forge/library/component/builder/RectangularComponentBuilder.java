package uk.co.codeecho.gdx.forge.library.component.builder;

import com.badlogic.gdx.math.Rectangle;
import uk.co.codeecho.gdx.forge.component.Component;
import uk.co.codeecho.gdx.forge.component.builder.ComponentBuilder;

public abstract class RectangularComponentBuilder<B extends RectangularComponentBuilder, C extends Component> implements ComponentBuilder<C>{
    
    protected Rectangle bounds = new Rectangle();
    
    public B setX(float x){
        bounds.x = x;
        return (B) this;
    }
    
    public B setY(float y){
        bounds.y = y;
        return (B) this;
    }
    
    public B setWidth(float width){
        bounds.width = width;
        return (B) this;
    }
    
    public B setHeight(float height){
        bounds.height = height;
        return (B) this;
    }
    
    public B setBounds(Rectangle bounds){
        this.bounds = bounds;
        return (B) this;
    }
}
