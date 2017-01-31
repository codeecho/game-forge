package uk.co.codeecho.gdx.forge.input;

import com.badlogic.gdx.InputAdapter;
import java.util.LinkedList;
import uk.co.codeecho.gdx.forge.GameManager;
import uk.co.codeecho.gdx.forge.Updatable;

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

    public void update(float delta) {
        for (Integer pressedKey : pressedKeys) {
            GameManager.getInstance().handle(new KeyPressedEvent(pressedKey));
        }
    }

}
