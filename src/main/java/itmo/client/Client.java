package itmo.client;

import itmo.common.Commands;
import itmo.common.RequestRecord;
import itmo.data.Flat;

import java.util.Scanner;

/**
 * класс обрабатывает пользовательский ввод и выводит на консоль результат команды
 */
public class Client {
    /**
     * обьект Scanner для диалога с пользователем
     */
    private Scanner scanner;

   public  Client () {
scanner = new Scanner(System.in);
    }
    public void printResult(String responce) {
       System.out.println(responce);
    }

    public RequestRecord getRequest() {
        System.out.println("Введите команду ");
        String input = scanner.nextLine();
        input = input.trim();
    String [] Strings = input.split(" ",2);
    System.out.println("проверка на корректность"+ Strings[0]);
        Commands command = Commands.valueOf(Strings[0]);
        String arg = "";
        if (Strings.length == 2) { arg = Strings[1]; }
        Flat flat = null;
        if (command == Commands.ADD) {flat = new Flat();}
        return new RequestRecord(command, arg, flat);

    }












}
