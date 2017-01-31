package uk.co.codeecho.gdx.forge.library.action;

import uk.co.codeecho.gdx.forge.StateTimeManager;
import uk.co.codeecho.gdx.forge.action.ResettableAction;

public class WaitAction implements ResettableAction {

    private StateTimeManager stateTimeManager = new StateTimeManager();

    private float period;

    public WaitAction(float period) {
        this.period = period;
    }

    @Override
    public boolean invoke(float delta) {
        stateTimeManager.update(delta);
        return stateTimeManager.getStateTime() >= period;
    }

    @Override
    public void reset() {
        stateTimeManager.reset();
    }

}
