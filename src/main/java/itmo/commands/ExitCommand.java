package itmo.commands;

import itmo.common.RequestRecord;

public class ExitCommand implements ICommand{
    @Override
    public String execute(RequestRecord record) {
        System.out.println("выход из программы");
        System.exit(0);
        return "";
    }
}
