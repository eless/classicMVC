package ru.rsdn.mvc.controller;

import ru.rsdn.mvc.model.Model;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 25.11.13; Time: 17:10
 */

/**
 *
 * @param <P>
 */
public class Controller<P> implements IController<Controller.O, Model<P>, P> {

    /**
     * @see IController implementations
     * @param operation O
     * @param model     M
     * @param attribute P
     */
    @Override
    public void execute(O operation, Model<P> model, P attribute) {
        if (operation == null)
            throw new NullPointerException("Empty operation parameter");
        if (model == null)
            throw new NullPointerException("Empty model parameter");
        if (attribute == null)
            throw new NullPointerException("Empty attribute parameter");
        switch (operation) {
            case EDIT:
                model.setProperty(attribute);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation:" + operation);
        }
    }

    public enum O {
        /**
         * operation EDIT
         */
        EDIT
    }
}
