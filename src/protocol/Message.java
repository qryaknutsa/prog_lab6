package protocol;

import java.io.Serializable;

public class Message implements Serializable {
    public String command;
    public Object args;

    public Message(String command, Object args) {
        this.command = command;
        this.args = args;
    }
}
