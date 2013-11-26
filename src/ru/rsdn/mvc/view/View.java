package ru.rsdn.mvc.view;

import ru.rsdn.mvc.model.Model;
import ru.rsdn.mvc.controller.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 26.11.13; Time: 11:25
 */
public abstract class View<P> extends BaseView<Model<P>, P>{
    private final Controller<P> controller = new Controller<P>();
    protected void edit(P property){
        controller.execute(Controller.O.EDIT, getModel(), property);
    }
}
