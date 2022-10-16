package server.server;

import protocol.Message;
import protocol.Response;

import java.io.*;
import java.net.*;

public class Server implements Serializable{

    private final DatagramSocket datagramSocket;

    byte[] buffer = new byte[9999999];
    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

    public Server(int port) throws SocketException {
        this.datagramSocket = new DatagramSocket(port);
    }

    public Message read() throws IOException, ClassNotFoundException {
        datagramSocket.receive(datagramPacket);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(datagramPacket.getData()));
        Object readingObject = ois.readObject();
        Message message = (Message) readingObject;
        ois.close();
        return message;
    }

    public void send(String answer) throws IOException, ClassNotFoundException {
        Response response = new Response(answer);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(5000);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.flush();
        oos.writeObject(response);
        oos.close();
        byte[] buffer = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, datagramPacket.getSocketAddress());
        datagramSocket.send(packet);

    }
}
