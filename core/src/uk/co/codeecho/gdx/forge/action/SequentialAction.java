package uk.co.codeecho.gdx.forge.action;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SequentialAction implements ResettableAction {

    private List<Action> actions;
    private List<Action> pendingActions;

    public SequentialAction(Action... actions) {
        this(new LinkedList<Action>(Arrays.asList(actions)));
    }

    public SequentialAction(List<Action> actions) {
        this.actions = actions;
        pendingActions = new LinkedList<Action>(actions);
    }
    
    public void addAction(Action action){
        actions.add(action);
        pendingActions.add(action);
    }

    @Override
    public boolean invoke(float delta) {
        if (pendingActions.isEmpty()) {
            return true;
        }
        Action action = pendingActions.get(0);
        if (action.invoke(delta)) {
            pendingActions.remove(0);
        }
        return pendingActions.isEmpty();
    }

    @Override
    public void reset() {
        for(Action action: actions){
            if(action instanceof ResettableAction){
                ((ResettableAction)action).reset();
            }
        }
        pendingActions = new LinkedList<Action>(actions);
    }

}
