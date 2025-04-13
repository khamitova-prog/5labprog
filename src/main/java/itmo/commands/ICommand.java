package itmo.commands;

import itmo.common.RequestRecord;

/**
 * интерфейс который будут реализовывать конкреиные команды введеные пользователем
 */
public interface ICommand {
    String execute(RequestRecord record);
}


