package server.handlers;

import commands.CommandsEnum;

import java.io.Serializable;


public class HelpHandler implements Handler, Serializable {

    CommandsEnum[] commands;

    public HelpHandler(CommandsEnum[] commands) {
        this.commands = commands;
    }

    @Override
    public String handle(Object args) {
        String str = "";
        str += "__________________________\n";
        StringBuilder strBuilder = new StringBuilder(str);
        for (CommandsEnum command : commands) {
            if (!command.description.equals("null")) {
                strBuilder.append(command.description).append("\n");
            }

        }
        str = strBuilder.toString();
        str += "__________________________";
        return str;
    }
}

