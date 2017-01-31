package uk.co.codeecho.gdx.forge.box2d.collision.event;

import uk.co.codeecho.gdx.forge.box2d.fixture.filter.AnyFixtureFilter;
import uk.co.codeecho.gdx.forge.box2d.fixture.filter.FixtureFilter;
import uk.co.codeecho.gdx.forge.event.TypeFilteringEventListener;

public abstract class CollisionEventListener<E extends CollisionEvent> extends TypeFilteringEventListener<E>{

    private FixtureFilter sourceFilter;
    private FixtureFilter targetFilter;

    public CollisionEventListener(Class<E> type, FixtureFilter targetFilter) {
        super(type);
        this.sourceFilter = new AnyFixtureFilter();
        this.targetFilter = targetFilter;
    }
    
    public CollisionEventListener(Class<E> type, FixtureFilter sourceFilter, FixtureFilter targetFilter) {
        super(type);
        this.sourceFilter = sourceFilter;
        this.targetFilter = targetFilter;
    }

    @Override
    public boolean doAccepts(E event) {
        return sourceFilter.accepts(event.getCollision().getSourceFixture()) && targetFilter.accepts(event.getCollision().getTargetFixture());
    }

    
}
