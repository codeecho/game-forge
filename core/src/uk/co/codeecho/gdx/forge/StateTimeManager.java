package uk.co.codeecho.gdx.forge;

import uk.co.codeecho.gdx.forge.component.Updatable;

public class StateTimeManager implements Updatable{

    private float stateTime = 0f;

    public float getStateTime() {
        return stateTime;
    }
    
    public void reset(){
        stateTime = 0f;
    }
    
    @Override
    public void update(float delta) {
        stateTime = stateTime + delta;
    }

}
