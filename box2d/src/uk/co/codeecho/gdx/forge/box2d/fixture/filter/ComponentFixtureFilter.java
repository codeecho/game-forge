package uk.co.codeecho.gdx.forge.box2d.fixture.filter;

import com.badlogic.gdx.physics.box2d.Fixture;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;
import uk.co.codeecho.gdx.forge.component.Component;

public class ComponentFixtureFilter implements FixtureFilter{

    private final Component component;

    public ComponentFixtureFilter(Component component) {
        this.component = component;
    }

    @Override
    public boolean accepts(Fixture fixture) {
        Component fixtureComponent = Box2DUtils.getComponent(fixture.getBody());
        return component.equals(fixtureComponent);
    }
    
}
