package uk.co.codeecho.gdx.forge.box2d.fixture.filter;

import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;
import uk.co.codeecho.gdx.forge.component.Component;

public class ComponentTypeFixtureFilter implements FixtureFilter{

    private final Class<? extends Component> type;

    public ComponentTypeFixtureFilter(Class<? extends Component> type) {
        this.type = type;
    }

    @Override
    public boolean accepts(Fixture fixture) {
        Component fixtureComponent = Box2DUtils.getComponent(fixture.getBody());
        return fixtureComponent != null && ClassReflection.isAssignableFrom(type, fixtureComponent.getClass());
    }
    
}
