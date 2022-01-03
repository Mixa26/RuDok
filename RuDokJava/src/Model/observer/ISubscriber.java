package Model.observer;

public interface ISubscriber {
    void update(Object notification, NotifyType type);
}
