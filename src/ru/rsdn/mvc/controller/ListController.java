package ru.rsdn.mvc.controller;

import ru.rsdn.mvc.model.ListModel;
import ru.rsdn.mvc.model.Model;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 25.11.13; Time: 17:22
 */
public class ListController<P> implements IController<ListController.O, ListModel<P>, Collection<Model<P>>> {
    @Override
    public void execute(O operation, ListModel<P> model, Collection<Model<P>> attribute) {
        if (operation == null)
            throw new NullPointerException("Пустой параметр operation");
        if (model == null)
            throw new NullPointerException("Пустой параметр model");
        if (attribute == null)
            throw new NullPointerException("Пустой параметр attribute");
        switch (operation) {
            case ADD:
                for (final Model<P> _model:attribute)
                    model.add(_model);
                break;
            case REMOVE:
                for (final Model<P> _model:attribute)
                    model.remove(_model);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
    public enum O {
        /**
         * operations ADD, REMOVE
         */
        ADD,
        REMOVE
    }
    @SuppressWarnings("unchecked")
    public void execute(O operation, ListModel<P> model, Model<P> attribute) {
        execute(operation, model, Arrays.asList(attribute));
    }
}
