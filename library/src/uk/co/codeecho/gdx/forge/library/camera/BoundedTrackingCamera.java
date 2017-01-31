package uk.co.codeecho.gdx.forge.library.camera;

import com.badlogic.gdx.math.Vector2;

public abstract class BoundedTrackingCamera extends BoundedCamera {

    private final float scale;

    public BoundedTrackingCamera(float viewportWidth, float viewportHeight, float xmin, float xmax, float ymin, float ymax, float scale) {
        super(viewportWidth, viewportHeight, xmin, xmax, ymin, ymax);
        this.scale = scale;
    }

    @Override
    public void update() {
        Vector2 targetPosition = getTargetPosition();
        if (targetPosition != null) {
            setPosition(targetPosition.x * scale, targetPosition.y * scale);
        }
        super.update();
    }

    public abstract Vector2 getTargetPosition();

}
