/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassThread;

/**
 *
 * @author WinD
 */
public class DepositThread extends Thread{
    private ATM atm;
    private int amount;

    public DepositThread(ATM atm, int amount) {
        this.atm = atm;
        this.amount = amount;
    }

    @Override
    public void run() {
        atm.deposit(amount);
    }
}
