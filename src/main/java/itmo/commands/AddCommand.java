package itmo.commands;

import itmo.common.RequestRecord;
import itmo.reciever.ControlCollection;

public class AddCommand implements ICommand{
    ControlCollection collection;

    public AddCommand(ControlCollection collection) {
        this.collection = collection;
    }

    @Override
    public String execute(RequestRecord record) {
        return "метод add";
    }
}
