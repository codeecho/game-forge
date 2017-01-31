package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.fixture.filter.FixtureFilter;

public class PreCollisionEventFilter extends CollisionEventFilter<PreCollisionEvent>{

    public PreCollisionEventFilter(FixtureFilter targetFilter) {
        super(PreCollisionEvent.class, targetFilter);
    }
    
    public PreCollisionEventFilter(FixtureFilter sourceFilter, FixtureFilter targetFilter) {
        super(PreCollisionEvent.class, sourceFilter, targetFilter);
    }

}
