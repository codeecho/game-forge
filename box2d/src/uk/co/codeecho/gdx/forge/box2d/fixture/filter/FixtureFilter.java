package uk.co.codeecho.gdx.forge.box2d.fixture.filter;

import com.badlogic.gdx.physics.box2d.Fixture;

public interface FixtureFilter {

    public boolean accepts(Fixture fixture);
    
}
