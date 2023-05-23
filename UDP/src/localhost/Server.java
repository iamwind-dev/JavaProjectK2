package localhost;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            int serverPort = 12345;

            DatagramSocket socket = new DatagramSocket(serverPort);

            System.out.println("Đang chờ kết nối từ client...");

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Giải mã dữ liệu
            String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String[] values = data.split(",");
            double a = Double.parseDouble(values[0]);
            double b = Double.parseDouble(values[1]);

            // Xử lý dữ liệu và tính toán kết quả
            String result = calculate(a, b, "+"); // Thay đổi toán tử tại đây

            // Gửi kết quả về cho client
            byte[] sendData = result.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);

            // Đóng socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calculate(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b != 0)
                    return String.valueOf(a / b);
                else
                    return "Lỗi: Phép chia cho 0!\";\n";
            default:
        return "Lỗi: Toán tử không hợp lệ!\";\n";
                }
}
}
