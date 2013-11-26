package ru.rsdn.mvc.model;

/**
 * Created with IntelliJ IDEA.
 * User: Eless
 * Date: 22.11.13
 * Time: 12:47
 * To change this template use File | Settings | File Templates.
 */
public interface IModelSubscriber<P> {
    void modelChanged(Model<P> model);
}
