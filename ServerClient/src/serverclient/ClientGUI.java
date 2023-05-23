/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ClientGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel aLabel, bLabel, resultLabel;
    private JTextField aField, bField, resultField;
    private JComboBox<String> operatorComboBox;
    private JButton calculateButton;
    private JPanel mainPanel;

    public ClientGUI() {
        super("TCP Client");

        // Thiết lập giao diện
        aLabel = new JLabel("Số a:");
        bLabel = new JLabel("Số b:");
        resultLabel = new JLabel("Kết quả:");

        aField = new JTextField(10);
        bField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        operatorComboBox = new JComboBox<>(new String[] {"+", "-", "*", "/"});

        calculateButton = new JButton("Tính toán");
        calculateButton.addActionListener(this);

        mainPanel = new JPanel(new GridLayout(4, 2));
        mainPanel.add(aLabel);
        mainPanel.add(aField);
        mainPanel.add(bLabel);
        mainPanel.add(bField);
        mainPanel.add(new JLabel("Toán tử:"));
        mainPanel.add(operatorComboBox);
        mainPanel.add(resultLabel);
        mainPanel.add(resultField);
        mainPanel.add(new JLabel());
        mainPanel.add(calculateButton);

        add(mainPanel);

        // Thiết lập cửa sổ
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Lấy giá trị từ ô nhập liệu
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());
        String operator = (String) operatorComboBox.getSelectedItem();

        try {
            // Kết nối tới server
            Socket clientSocket = new Socket("192.168.1.54", 1234);

            // Gửi yêu cầu tính toán tới server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(a + "," + b + "," + operator);

            // Nhận kết quả tính toán từ server
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String result = in.readLine();

            // Hiển thị kết quả lên ô nhập liệu
            resultField.setText(result);

            // Đóng kết nối
            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
{
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI();
            }
        });
    }
}

