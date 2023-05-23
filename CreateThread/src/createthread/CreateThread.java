/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package createthread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateThread {
    // Hàm tính diện tích hình chữ nhật
    public static void area(float length, float width, List<Float> result) {
        float area = length * width;
        result.add(area);
    }

    // Hàm tính chu vi hình chữ nhật
    public static void perimeter(float length, float width, List<Float> result) {
        float perimeter = 2 * (length + width);
        result.add(perimeter);
    }

    public static void main(String[] args) {
        // Nhập vào 2 cạnh của hình chữ nhật
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai hinh chu nhat: ");
        float length = sc.nextFloat();
        System.out.print("Nhap chieu rong hinh chu nhat: ");
        float width = sc.nextFloat();

        // Khởi tạo danh sách kết quả
        List<Float> result = new ArrayList<>();

        // Tạo luồng tính diện tích
        Thread t1 = new Thread(() -> area(length, width, result));

        // Tạo luồng tính chu vi
        Thread t2 = new Thread(() -> perimeter(length, width, result));

        // Bắt đầu chạy các luồng
        t1.start();
        t2.start();

        try {
            // Chờ cho tất cả các luồng hoàn thành
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In kết quả
        System.out.println("Dien tich: " + result.get(0));
        System.out.println("Chu vi: " + result.get(1));
    }
}

