package ru.rsdn.mvc.view;

import ru.rsdn.mvc.controller.Controller;
import ru.rsdn.mvc.controller.ListController;
import ru.rsdn.mvc.model.ListModel;
import ru.rsdn.mvc.model.Model;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 26.11.13; Time: 12:19
 */
public abstract class ListView<P> extends
        BaseView<ListModel<P>, Collection<Model<P>>>{
    private final Controller<P> controller = new Controller<P>();
    private final ListController<P> listController = new ListController<P>();

    /**
     * ADD
     * @param model
     */
    protected void add (Model<P> model){
        listController.execute(ListController.O.ADD, getModel(), model);
    }

    /**
     * EDIT
     * @param model
     * @param property
     */
    protected void edit(Model<P> model, P property){
        controller.execute(Controller.O.EDIT, model, property);

    }

    /**
     * REMOVE
     * @param model
     */
    protected void remove(Model<P> model){
        listController.execute(ListController.O.REMOVE, getModel(), model);
    }

}
