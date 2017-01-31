package uk.co.codeecho.gdx.forge.box2d.fixture.filter;

import com.badlogic.gdx.physics.box2d.Fixture;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;

public class BodyTypeFixtureFilter implements FixtureFilter {

    public final String bodyType;

    public BodyTypeFixtureFilter(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean accepts(Fixture fixture) {
        boolean accepts = bodyType.equals(Box2DUtils.getMetaData(fixture.getBody()).getType());
        return accepts;
    }

}
