package itmo;

import itmo.client.Client;
import itmo.commands.ICommand;
import itmo.data.Flat;
import itmo.invocer.Invocer;
import itmo.reciever.ControlCollection;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        Client client = new Client();

        ControlCollection reciever = new ControlCollection(new ArrayList<Flat>());
        Invocer invocer = new Invocer(client, reciever);
        invocer.run();
    }
}
