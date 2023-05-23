package localhost;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            DatagramSocket socket = new DatagramSocket();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhập số a: ");
            double a = Double.parseDouble(reader.readLine());
            System.out.print("Nhập số b: ");
            double b = Double.parseDouble(reader.readLine());

            // Gửi hai số cho server
            String data = a + "," + b;
            byte[] sendData = data.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            // Nhận kết quả từ server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Hiển thị kết quả
            System.out.println("Kết quả: " + result);

            // Đóng socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

