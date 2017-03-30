package uk.co.codeecho.gdx.forge.observer;

import java.util.ArrayList;
import java.util.List;
import uk.co.codeecho.gdx.forge.component.Updatable;

public class Observable<S, K> implements Updatable {

    private final S subject;
    private final Identifier<S, K> identifier;

    private K currentIdentity;

    private List<Observer<S, K>> observers = new ArrayList<Observer<S, K>>();

    public Observable(S subject, Identifier<S, K> identifier) {
        this.subject = subject;
        this.identifier = identifier;
        observe();
    }

    @Override
    public void update(float delta) {
        observe();
    }

    private void observe() {
        K newIdentity = identifier.identify(subject);
        if (!newIdentity.equals(currentIdentity)) {
            notifySubscribers(currentIdentity, newIdentity);
            currentIdentity = newIdentity;
        }
    }

    private void notifySubscribers(K oldIdentity, K newIdentity) {
        for (Observer<S, K> observer : observers) {
            observer.onChange(subject, oldIdentity, newIdentity);
        }
    }

    public void subscribe(Observer<S, K> observer) {
        observers.add(observer);
    }

}
