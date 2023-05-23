/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassThread;

/**
 *
 * @author WinD
 */
public class WithdrawThread extends Thread{
     private ATM atm;
    private int amount;

    public WithdrawThread(ATM atm, int amount) {
        this.atm = atm;
        this.amount = amount;
    }

    @Override
    public void run() {
        atm.withdraw(amount);
    }
    
}
