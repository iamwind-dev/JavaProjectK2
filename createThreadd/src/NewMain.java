
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author WinD
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chieu dai:");
        float cd=sc.nextFloat();
        System.out.println("Nhap chieu rong:");
        float cr=sc.nextFloat();
        // Tạo luồng tính diện tích
        Dientich dt = new Dientich(cd, cr);
        Thread t1 = new Thread(dt);
        // Tạo luồng tính chu vi
        Chuvi cv = new Chuvi(cd, cr);
        Thread t2 = new Thread(cv);
        // Khởi chạy 2 luồng
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
        System.out.println("Dien tich: " + dt.getDt());
        System.out.println("Chu vi: " + cv.getCv());
    }
    
}
