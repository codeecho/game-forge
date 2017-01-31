package uk.co.codeecho.gdx.forge.box2d.collision;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import net.dermetfan.gdx.physics.box2d.ContactAdapter;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.box2d.util.Box2DUtils;
import uk.co.codeecho.gdx.forge.box2d.collision.event.CollisionEndEvent;
import uk.co.codeecho.gdx.forge.box2d.collision.event.CollisionStartEvent;
import uk.co.codeecho.gdx.forge.box2d.collision.event.PreCollisionEvent;
import uk.co.codeecho.gdx.forge.component.Component;

public class WorldCollisionListener extends ContactAdapter {

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        Fixture fixtureA = contact.getFixtureA();
        Body bodyA = fixtureA.getBody();
        Component componentA = Box2DUtils.getComponent(bodyA);
        Fixture fixtureB = contact.getFixtureB();
        Body bodyB = fixtureB.getBody();
        Component componentB = Box2DUtils.getComponent(bodyB);
        GameManager.getInstance().handle(new PreCollisionEvent(new Collision(fixtureA, fixtureB, componentA, componentB, contact)));
        GameManager.getInstance().handle(new PreCollisionEvent(new Collision(fixtureB, fixtureA, componentB, componentA, contact)));
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Body bodyA = fixtureA.getBody();
        Component componentA = Box2DUtils.getComponent(bodyA);
        Fixture fixtureB = contact.getFixtureB();
        Body bodyB = fixtureB.getBody();
        Component componentB = Box2DUtils.getComponent(bodyB);
        GameManager.getInstance().handle(new CollisionStartEvent(new Collision(fixtureA, fixtureB, componentA, componentB, contact)));
        GameManager.getInstance().handle(new CollisionStartEvent(new Collision(fixtureB, fixtureA, componentB, componentA, contact)));
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Body bodyA = fixtureA.getBody();
        Component componentA = Box2DUtils.getComponent(bodyA);
        Fixture fixtureB = contact.getFixtureB();
        Body bodyB = fixtureB.getBody();
        Component componentB = Box2DUtils.getComponent(bodyB);
        GameManager.getInstance().handle(new CollisionEndEvent(new Collision(fixtureA, fixtureB, componentA, componentB, contact)));
        GameManager.getInstance().handle(new CollisionEndEvent(new Collision(fixtureB, fixtureA, componentB, componentA, contact)));
    }

}
