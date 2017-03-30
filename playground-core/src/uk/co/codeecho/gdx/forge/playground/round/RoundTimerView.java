package uk.co.codeecho.gdx.forge.playground.round;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import java.text.DecimalFormat;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.mutable.MutableFloat;
import uk.co.codeecho.gdx.forge.library.renderable.Scene2DWidgetRenderable;
import uk.co.codeecho.gdx.forge.library.scene2d.Scene2DRenderer;

public class RoundTimerView extends Scene2DWidgetRenderable<Label> {

    private final DecimalFormat format = new DecimalFormat("0.0");
    
    private final MutableFloat roundTime;

    public RoundTimerView(Scene2DRenderer renderer, Rectangle bounds, MutableFloat roundTime) {
        super(renderer, buildLabel(bounds));
        this.roundTime = roundTime;
    }

    @Override
    public void render() {
        widget.setText(format.format(roundTime.getValue()));
        super.render();
    }

    private static Label buildLabel(Rectangle bounds) {
        Label label = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        bounds = GameManager.getInstance().unitsToPixels(bounds);
        label.setPosition(bounds.x, bounds.y);
        label.setSize(bounds.width, bounds.height);
        label.setFontScale(1f);
        label.setAlignment(Align.center);
        return label;
    }

}
