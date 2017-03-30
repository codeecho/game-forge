package uk.co.codeecho.gdx.forge.playground.round;

import uk.co.codeecho.gdx.forge.library.component.builder.RectangularComponentBuilder;
import uk.co.codeecho.gdx.forge.mutable.MutableFloat;
import uk.co.codeecho.gdx.forge.library.scene2d.Scene2DRenderer;

public class RoundTimerBuilder extends RectangularComponentBuilder<RoundTimerBuilder, RoundTimer> {

    private final Scene2DRenderer renderer;

    public RoundTimerBuilder(Scene2DRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public RoundTimer build() {
        MutableFloat roundTime = new MutableFloat(30);
        RoundTimerView view = new RoundTimerView(renderer, bounds, roundTime);
        RoundTimer component = new RoundTimer(view, roundTime);
        return component;
    }

}
