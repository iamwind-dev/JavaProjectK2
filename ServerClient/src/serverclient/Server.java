package serverclient;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Tạo server socket để lắng nghe kết nối từ client
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server đã sẵn sàng để nhận kết nối.");

            // Chấp nhận kết nối từ client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Đã có kết nối từ client: " + clientSocket.getInetAddress());

            // Tạo đối tượng để nhận dữ liệu từ client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Tạo đối tượng để gửi dữ liệu tới client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Đọc hai số double từ client
            double a = Double.parseDouble(in.readLine());
            double b = Double.parseDouble(in.readLine());

            // Đọc toán tử từ client
            String operator = in.readLine();

            // Tính toán kết quả
            double result = 0;
            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0)
                        result = a / b;
                    else
                        System.out.println("Lỗi: Không thể chia cho 0.");
                    break;
                default:
                    System.out.println("Lỗi: Toán tử không hợp lệ.");
                    break;
            }

        // Gửi kết quả về client
        out.println(result);

        // Đóng kết nối
        clientSocket.close();
        serverSocket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}