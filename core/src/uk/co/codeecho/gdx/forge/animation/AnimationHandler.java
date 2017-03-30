package uk.co.codeecho.gdx.forge.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.LinkedList;
import uk.co.codeecho.gdx.forge.component.Renderable;
import uk.co.codeecho.gdx.forge.StateTimeManager;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.predicate.Predicate;

public class AnimationHandler implements Updatable, Renderable{

    private final LinkedList<PossibleAnimation> possibleAnimations;
    private final StateTimeManager stateTimeManager;
    private final Object model;
    private final AnimationFrameRenderer defaultAnimationFrameRenderer;

    public AnimationHandler(Object model, AnimationFrameRenderer defaultAnimationFrameRenderer) {
        this.stateTimeManager = new StateTimeManager();
        this.possibleAnimations = new LinkedList<PossibleAnimation>();
        this.model = model;
        this.defaultAnimationFrameRenderer = defaultAnimationFrameRenderer;
    }

    public void addAnimation(Predicate predicate, Animation animation) {
        addAnimation(predicate, animation, defaultAnimationFrameRenderer);
    }

    public void addAnimation(Predicate predicate, Animation animation, AnimationFrameRenderer animationFrameRenderer) {
        possibleAnimations.add(new PossibleAnimation(predicate, animation, animationFrameRenderer));
    }

    private PossibleAnimation getAnimation(Object viewModel) {
        for (PossibleAnimation possibleAnimation : possibleAnimations) {
            if (possibleAnimation.predicate.evaluate(viewModel)) {
                return possibleAnimation;
            }
        }
        return null;
    }

    public void update(float delta) {
        stateTimeManager.update(delta);
    }

    public void render() {
        PossibleAnimation animation = getAnimation(model);
        if (animation != null) {
            TextureRegion textureRegion = animation.animation.getKeyFrame(stateTimeManager.getStateTime());
            animation.animationFrameRenderer.render(textureRegion, model);
        }
    }

    private class PossibleAnimation {

        private Predicate predicate;
        private Animation animation;
        private AnimationFrameRenderer animationFrameRenderer;

        public PossibleAnimation(Predicate predicate, Animation animation, AnimationFrameRenderer textureRenderer) {
            this.predicate = predicate;
            this.animation = animation;
            this.animationFrameRenderer = textureRenderer;
        }

    }

}
