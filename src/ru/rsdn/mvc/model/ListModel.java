package ru.rsdn.mvc.model;


import java.util.Collection;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 22.11.13
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
public class ListModel<P> extends Model<Collection<Model<P>>>
        implements IModelSubscriber<P> {

    public ListModel(){
        super(new HashSet<Model<P>>());
    }
    public void add(Model<P> model){
        if (model == null)
            throw new NullPointerException("Empty parameter");
        getProperty().add(model);
        model.subscribe(this);

    }

    /**
     *
     * @param model
     */
    @Override
    public void modelChanged(Model<P> model) {
        if (model == null)
            throw new NullPointerException("Empty parameter");
        notifySubscribers();
    }

    /**
     *
     * @param model
     */
    public void remove(Model<P> model){
        if (model == null)
            throw new NullPointerException("Empty parameter");
        getProperty().remove(model);
        notifySubscribers();
    }
}
