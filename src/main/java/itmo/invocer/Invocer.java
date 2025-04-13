package itmo.invocer;

import itmo.client.Client;
import itmo.commands.*;
import itmo.common.Commands;
import itmo.common.RequestRecord;
import itmo.reciever.ControlCollection;

public class Invocer {
    Client client;
    ControlCollection reciever;
    private RequestRecord record;

    public Invocer(Client client, ControlCollection collection) {
        this.client = client;
        this.reciever = collection;
        this.record = new RequestRecord(Commands.ADD,"",null);

    }

    public RequestRecord getRecord() {
        return record;
    }

    /**
     * проебразовывает имя команды в обьтект Commands
     * сохраняет записку от клиента
     * @return обьект команды
     */
    public ICommand getCommand() {
        ICommand cmd;
        record = client.getRequest();
        Commands nameCommand = record.command();
        return switch (nameCommand) {
            case ADD -> new AddCommand(reciever);
            case EXIT ->  new ExitCommand();
        case HELP -> new HelpCommand();
            case REMOVE_BY_ID -> new Remove_by_id(reciever);
        };
    }

    /**
     * выполняет запрос от клиента пока не получит exit
     */
    public void run () {
        do {

            String responce = this.getCommand().execute(record);
            client.printResult(responce);

        } while (record.command() != Commands.EXIT);


    }

}
