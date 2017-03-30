package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.fixture.filter.FixtureFilter;

public abstract class CollisionStartEventListener extends CollisionEventListener<CollisionStartEvent>{

    public CollisionStartEventListener(FixtureFilter targetFilter) {
        super(CollisionStartEvent.class, targetFilter);
    }

    public CollisionStartEventListener(FixtureFilter sourceFilter, FixtureFilter targetFilter) {
        super(CollisionStartEvent.class, sourceFilter, targetFilter);
    }

}
