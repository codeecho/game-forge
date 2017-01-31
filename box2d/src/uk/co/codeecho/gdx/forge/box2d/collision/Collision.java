package uk.co.codeecho.gdx.forge.box2d.collision;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import uk.co.codeecho.gdx.forge.component.Component;

public class Collision {

    private Fixture sourceFixture;
    private Fixture targetFixture;
    private Component sourceComponent;
    private Component targetComponent;
    private Contact contact;

    public Collision(Fixture sourceFixture, Fixture targetFixture, Component sourceComponent, Component targetComponent, Contact contact) {
        this.sourceFixture = sourceFixture;
        this.targetFixture = targetFixture;
        this.sourceComponent = sourceComponent;
        this.targetComponent = targetComponent;
        this.contact = contact;
        
    }

    public Fixture getSourceFixture() {
        return sourceFixture;
    }

    public Fixture getTargetFixture() {
        return targetFixture;
    }

    public Body getSourceBody() {
        return getSourceFixture().getBody();
    }

    public Body getTargetBody() {
        return getTargetFixture().getBody();
    }

    public Component getSourceComponent() {
        return sourceComponent;
    }

    public Component getTargetComponent() {
        return targetComponent;
    }
    
    public void cancel(){
        contact.setEnabled(false);
    }

}
