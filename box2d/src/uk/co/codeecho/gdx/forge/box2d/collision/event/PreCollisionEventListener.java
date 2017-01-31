package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.fixture.filter.FixtureFilter;

public abstract class PreCollisionEventListener extends CollisionEventListener<PreCollisionEvent>{

    public PreCollisionEventListener(FixtureFilter targetFilter) {
        super(PreCollisionEvent.class, targetFilter);
    }

    public PreCollisionEventListener(FixtureFilter sourceFilter, FixtureFilter targetFilter) {
        super(PreCollisionEvent.class, sourceFilter, targetFilter);
    }

}
