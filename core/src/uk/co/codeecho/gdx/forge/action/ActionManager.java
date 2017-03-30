package uk.co.codeecho.gdx.forge.action;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import uk.co.codeecho.gdx.forge.component.Updatable;

public class ActionManager implements Updatable{

    private List<Action> actions = new LinkedList<Action>();
    private List<Action> actionsToAdd = new LinkedList<Action>();
    
    public void addAction(Action action){
        actionsToAdd.add(action);
    }
    
    @Override
    public void update(float delta){
        actions.addAll(actionsToAdd);
        actionsToAdd.clear();
        Iterator<Action> iterator = actions.listIterator();
        while(iterator.hasNext()){
            Action action = iterator.next();
            if(action.invoke(delta)){
                iterator.remove();
            }
        }
    }
    
}
