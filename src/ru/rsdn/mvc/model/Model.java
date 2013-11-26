package ru.rsdn.mvc.model;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 22.11.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */

public class Model<P> {
    private P property;
    private final Collection<IModelSubscriber<P>> subscribers = new CopyOnWriteArrayList<IModelSubscriber<P>>();

    public Model(P property){
        if (property == null)
                throw new NullPointerException("Empty parameter");
        this.property = property;
    }
    public P getProperty(){
        return property;
    }

    public void setProperty(P property) {
        if (property == null)
            throw new NullPointerException("Empty parameter");
        this.property = property;
        notifySubscribers();
    }

    protected void notifySubscribers() {
        for(final IModelSubscriber<P> subscriber : subscribers)
            notifySubscriber(subscriber);
    }

    public void notifySubscriber(IModelSubscriber<P> subscriber) {
        assert subscriber != null;
        subscriber.modelChanged(this);
    }

    public void subscribe(IModelSubscriber<P> subscriber){
        if (subscriber == null)
             throw new NullPointerException("Empty parameter");
        if (subscribers.contains(subscriber))
            throw new IllegalArgumentException("Existing Subscriber: " + subscriber);
        subscribers.add(subscriber);
    }
    public void unsubscribe(IModelSubscriber<P> subscriber){
        if (subscriber == null)
            throw new NullPointerException("Empty parameter");
        if (!subscribers.contains(subscriber))
            throw new IllegalArgumentException("Unknown subscriber: " + subscriber);
        subscribers.remove(subscriber);
    }

    @Override
    public String toString(){
        return property.toString();
    }
}
