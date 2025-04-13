package itmo.reciever;

import java.util.Collection;

/**
 * класс управляет коллекцией
 */
public class ControlCollection {
    private final Collection collection;

    public ControlCollection(Collection collection) {
        this.collection = collection;
    }

    public Collection getCollection() {
        return collection;
    }

    public String toString() {
        return "это обьект ресивера";
    }

}
