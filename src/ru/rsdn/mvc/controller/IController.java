package ru.rsdn.mvc.controller;

import ru.rsdn.mvc.model.Model;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 25.11.13; Time: 16:24
 */

/**
 *
 * @param <O> operation
 * @param <M> model
 * @param <P> property of model
 */
public interface IController<O, M extends Model<P>, P> {
    /**
     *
     * @param operation O
     * @param model     M
     * @param attribute P
     */
    void execute(O operation, M model, P attribute);
}
