package uk.co.codeecho.gdx.forge.library.event.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.World;
import java.util.ArrayList;
import java.util.List;
import uk.co.codeecho.gdx.forge.event.EventListener;
import uk.co.codeecho.gdx.forge.event.TypeFilteringEventListener;
import uk.co.codeecho.gdx.forge.input.touch.TouchEvent;

public class Box2dTouchListener extends TypeFilteringEventListener<TouchEvent> {

    private final World world;
    private final EventListener eventListener;

    public Box2dTouchListener(World world, EventListener eventListener) {
        super(TouchEvent.class);
        this.world = world;
        this.eventListener = eventListener;
    }

    @Override
    public boolean doAccepts(TouchEvent event) {
        Vector2 coordinates = event.getCoordinates();
        final List<Fixture> hits = new ArrayList<Fixture>();
        world.QueryAABB(new QueryCallback() {

            @Override
            public boolean reportFixture(Fixture fixture) {
                eventListener.handle(new FixtureTouchUpEvent(fixture));
                hits.add(fixture);
                return false;
            }
        }, coordinates.x, coordinates.y, coordinates.x, coordinates.y);
        return !hits.isEmpty();
    }

    @Override
    public void doHandle(TouchEvent event) {
        
    }

}
