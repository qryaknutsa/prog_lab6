package client.handlers;


import java.io.IOException;

public interface Handler {
    String handle(String[] args) throws IOException, ClassNotFoundException;
}
