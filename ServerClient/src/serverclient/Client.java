
package serverclient;


import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Kết nối tới server
            Socket socket = new Socket("192.168.1.54", 1234);
            
            // Tạo đối tượng để gửi dữ liệu tới server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Tạo đối tượng để nhận dữ liệu từ server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Nhập hai số double từ người dùng
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhập số a: ");
            double a = Double.parseDouble(userInput.readLine());
            System.out.print("Nhập số b: ");
            double b = Double.parseDouble(userInput.readLine());

            // Gửi hai số a và b tới server
            out.println(a);
            out.println(b);

            // Nhập toán tử từ người dùng
            System.out.print("Nhập toán tử (+, -, *, /): ");
            String operator = userInput.readLine();

            // Gửi toán tử tới server
            out.println(operator);

            // Đọc kết quả từ server và hiển thị ra màn hình
            String result = in.readLine();
            System.out.println("Kết quả: " + result);

            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
