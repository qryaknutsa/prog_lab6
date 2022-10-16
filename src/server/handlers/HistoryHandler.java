package server.handlers;


import commands.CommandsEnum;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoryHandler implements Handler, Serializable {

    CommandsEnum[] commands;

    public HistoryHandler(CommandsEnum[] commands) {
        this.commands = commands;
    }

    @Override
    public String handle(Object args) {
        ArrayList<String> history = (ArrayList<String>) args;

        StringBuilder str = new StringBuilder();
        int i = 0;
        while (history.size() > 9) {
            history.remove(i);
            i++;
        }
        for (String lines : history) {
            str.append(lines);
            str.append("\n");
        }
        if (str.length()==0) {
             str.append("Выполненных команд ещё нет.");
        }
        return str.toString();
    }
}