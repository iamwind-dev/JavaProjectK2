/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassThread;

/**
 *
 * @author WinD
 */
public class ATM {

    private int balance = 0; // số tiền trong tài khoản

    public synchronized void withdraw(int amount) {
        System.out.println("Rut tien " + amount + " dong...");
        while (balance < amount) {
            System.out.println("Khong du tien trong tai khoan, cho doi...");
            try {
                wait(); // chờ đợi nạp tiền để có đủ số dư
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount; // cập nhật số tiền trong tài khoản
        System.out.println("Rut tien thnh cong, so du moi trong tai khoan la " + balance + " dong");
    }
    
     public synchronized void deposit(int amount) {
        System.out.println("Nap tien " + amount + " dong...");
        balance += amount; // cập nhật số tiền trong tài khoản
        System.out.println("Nap tien thanh cong, so du moi trong tai khoan la " + balance + " dong");
        notifyAll(); // thông báo đã nạp tiền để có thể tiếp tục rút tiền
    }
}
