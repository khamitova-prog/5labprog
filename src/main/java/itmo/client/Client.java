package itmo.client;

import itmo.common.Arguments;
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
    final private Scanner scanner;

    public Client() {
        scanner = new Scanner(System.in);
    }

    public void printResult(String responce) {
        System.out.println(responce);
    }

    private String[] separete(String input) {
        String[] Strings = input.trim().split(" ", 2);
        Strings[0] = Strings[0].toUpperCase();
        return Strings;
    }

    private boolean checkArgument(String[] strings) {
        if ((strings.length == 1) && (Commands.valueOf(strings[0]).getArgument() != Arguments.NO_ARGUMENT)) {
            System.out.println("ошибка! команда" + " " + strings[0] + "должна быть без аргумента ");
            return false;
        }
        if ((strings.length == 2) && (Commands.valueOf(strings[0]).getArgument() == Arguments.NO_ARGUMENT)) {
            System.out.println("ошибка! команда" + strings[0] + "не должна иметь аргумент");
            return false;
        }
        if ((strings.length == 2) && (Commands.valueOf(strings[0]).getArgument() == Arguments.INT_ARGUMENT)) {
            try {
                Integer.parseInt(strings[1]);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("ошибка! команда" + strings[1] + "имеет аргументом целое число");
                return false;
            }

        }
        return true;
    }

    public RequestRecord getRequest() {
        String[] Strings;

        while (true) {
            System.out.println("Введите команду ");
            String input = scanner.nextLine();
            Strings = separete(input);
            if (!Commands.checkvalue(Strings[0])) {
                System.out.println("ошибка! введенная команда отсутсвует./n" + " " + "для получения списка доступных комманд введите HELP");
                continue;

            }
            if (!checkArgument(Strings)) {
                continue;
            }
            break;
        }

        Commands command = Commands.valueOf(Strings[0]);
        String arg = "";
        if (Strings.length == 2) {
            arg = Strings[1];
        }
        Flat flat = null;
        if (command == Commands.ADD) {
            flat = new Flat();
        }
        return new RequestRecord(command, arg, flat);


    }
}













