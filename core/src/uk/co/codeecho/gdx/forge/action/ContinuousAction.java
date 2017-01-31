package uk.co.codeecho.gdx.forge.action;

public abstract class ContinuousAction implements Action{

    @Override
    public boolean invoke(float delta) {
        doInvoke(delta);
        return false;
    }
    
    public abstract void doInvoke(float delta);

}
