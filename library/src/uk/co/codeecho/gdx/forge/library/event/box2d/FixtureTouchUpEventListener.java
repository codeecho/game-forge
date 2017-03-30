package uk.co.codeecho.gdx.forge.library.event.box2d;

import uk.co.codeecho.gdx.forge.box2d.fixture.filter.FixtureFilter;
import uk.co.codeecho.gdx.forge.event.TypeFilteringEventListener;

public abstract class FixtureTouchUpEventListener extends TypeFilteringEventListener<FixtureTouchUpEvent>{

    private FixtureFilter fixtureFilter;
    
    public FixtureTouchUpEventListener() {
        super(FixtureTouchUpEvent.class);
    }

    public FixtureTouchUpEventListener(FixtureFilter fixtureFilter) {
        super(FixtureTouchUpEvent.class);
        this.fixtureFilter = fixtureFilter;
    }

    @Override
    public boolean doAccepts(FixtureTouchUpEvent event) {
        return fixtureFilter == null || fixtureFilter.accepts(event.getFixture());
    }

}
