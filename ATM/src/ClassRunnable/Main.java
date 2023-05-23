
package ClassRunnable;


public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread withdrawThread = new Thread(new WithdrawThread(atm, 500));
        Thread depositThread = new Thread(new DepositThread(atm, 1000));
        withdrawThread.start();
        depositThread.start();
    }
    
}
