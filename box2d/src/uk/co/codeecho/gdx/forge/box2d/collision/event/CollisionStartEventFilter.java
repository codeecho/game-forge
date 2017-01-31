package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.fixture.filter.FixtureFilter;

public class CollisionStartEventFilter extends CollisionEventFilter<CollisionStartEvent>{

    public CollisionStartEventFilter(FixtureFilter targetFilter) {
        super(CollisionStartEvent.class, targetFilter);
    }
    
    public CollisionStartEventFilter(FixtureFilter sourceFilter, FixtureFilter targetFilter) {
        super(CollisionStartEvent.class, sourceFilter, targetFilter);
    }

}
