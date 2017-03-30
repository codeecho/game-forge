package uk.co.codeecho.gdx.forge.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import uk.co.codeecho.gdx.forge.input.key.KeyDownEvent;
import uk.co.codeecho.gdx.forge.input.key.KeyUpEvent;
import uk.co.codeecho.gdx.forge.input.key.KeyPressedEvent;
import uk.co.codeecho.gdx.forge.input.key.KeyTypedEvent;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import java.util.LinkedList;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.component.Updatable;
import uk.co.codeecho.gdx.forge.input.touch.TouchUpEvent;

public class InputProcessor extends InputAdapter implements Updatable {

    private final LinkedList<Integer> pressedKeys = new LinkedList<Integer>();

    @Override
    public boolean keyUp(int keycode) {
        if (pressedKeys.contains(keycode)) {
            pressedKeys.remove(new Integer(keycode));
        }
        GameManager.getInstance().handle(new KeyUpEvent(keycode));
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        pressedKeys.add(keycode);
        GameManager.getInstance().handle(new KeyDownEvent(keycode));
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        GameManager.getInstance().handle(new KeyTypedEvent(character));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector2 coordinates = new Vector2(screenX, screenY);
        coordinates = GameManager.getInstance().pixelsToUnits(coordinates);
        coordinates.y = GameManager.getInstance().getDisplayHeightInUnits() - coordinates.y;
        GameManager.getInstance().handle(new TouchUpEvent(coordinates, pointer, button));
        return true;
    }

    public void update(float delta) {
        for (Integer pressedKey : pressedKeys) {
            GameManager.getInstance().handle(new KeyPressedEvent(pressedKey));
        }
    }

}
