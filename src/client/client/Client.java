package client.client;

import protocol.Message;
import protocol.Response;


import java.io.*;
import java.net.*;

public class Client implements Serializable{

    private final InetSocketAddress inetSocketAddress;
    private final DatagramSocket datagramSocket;

    public Client(String host, int port) throws UnknownHostException, SocketException {
        this.inetSocketAddress = new InetSocketAddress(InetAddress.getByName(host), port);
        this.datagramSocket = new DatagramSocket();
    }

    public String send(String command, Object args) throws IOException, ClassNotFoundException {
        Message message = new Message(command, args);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(5000);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.flush();
        oos.writeObject(message);
        oos.close();
        byte[] buffer = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetSocketAddress);
        datagramSocket.send(packet);
        return read();

    }

    public String read() throws IOException, ClassNotFoundException {
        byte[] buffer = new byte[999999];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);
        datagramSocket.setSoTimeout(12000);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(datagramPacket.getData()));
        Response response = (Response) ois.readObject();
        if (response.getResponse().contains("Происходит выход из консоли...")) {
            System.out.println(response.getResponse());
            System.exit(0);
        }
        return response.getResponse();
    }
}
