package uk.co.codeecho.gdx.forge.box2d.fixture.filter;

import com.badlogic.gdx.physics.box2d.Fixture;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;

public class IdFixtureFilter implements FixtureFilter{

    private final String id;

    public IdFixtureFilter(String id) {
        this.id = id;
    }

    @Override
    public boolean accepts(Fixture fixture) {
        boolean accepts = id.equals(Box2DUtils.getMetaData(fixture).getId());
        return accepts;
    }
    
}
