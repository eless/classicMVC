package ru.rsdn.mvc.view;

import ru.rsdn.mvc.model.IModelSubscriber;
import ru.rsdn.mvc.model.Model;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 25.11.13; Time: 18:08
 */
public abstract class BaseView<M extends Model<P>, P>
        implements IModelSubscriber<P> {
    private M model;

    /**
     *
     * @return model;
     */
    protected M getModel(){
        return model;
    }
    public void setModel(M model){
        unsubscribe();
        this.model = model;
        subscribe();
    }

    /**
     * subscriber
     */
    private void subscribe() {
       if(model != null)
           model.unsubscribe(this);
    }

    /**
     * unsubscriber
     */
    private void unsubscribe(){
        if (model != null)
            model.unsubscribe(this);
    }

    /**
     * disposer
     */
    public void dispose(){
        unsubscribe();
    }
}
