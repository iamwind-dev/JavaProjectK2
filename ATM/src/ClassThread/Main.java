
package ClassThread;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        WithdrawThread withdrawThread = new WithdrawThread(atm, 500);
        DepositThread depositThread = new DepositThread(atm, 1000);
        withdrawThread.start();
        depositThread.start();
    }
    }
    

