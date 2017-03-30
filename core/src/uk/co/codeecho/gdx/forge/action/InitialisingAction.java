package uk.co.codeecho.gdx.forge.action;

public abstract class InitialisingAction implements ResettableAction{

    private boolean initialised = false;
    
    @Override
    public boolean invoke(float delta) {
        if(!initialised){
            initialise();
            initialised = true;
        }
        return doInvoke(delta);
    }
    
    public abstract void initialise();
    
    public abstract boolean doInvoke(float delta);

    @Override
    public void reset() {
        initialised = false;
        doReset();
    }
    
    public void doReset(){
        
    }

}
