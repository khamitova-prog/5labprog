package itmo.commands;

import itmo.common.RequestRecord;
import itmo.reciever.ControlCollection;

public class Remove_by_id implements ICommand
{ ControlCollection collection;

    public Remove_by_id(ControlCollection collection) {
        this.collection = collection;
    }

    @Override
    public String execute(RequestRecord record) {
        return "метод remove";
    }
}
