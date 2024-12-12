package Ex1;

import Ex1.Exception.NoMoneyException;
import Ex1.Exception.ServerNotFoundException;

import java.util.Scanner;

public class TerminalServer {
    private final int server = 111;
    private int typeOfOperation;
    private Account account = new Account(10000);
    Message message = new Message();

    public TerminalServer(){
    }
    public double getBalance() {
        return account.getBalance();
    }

    public void setBalancePut(double sum){
        double newBalance = account.getBalance()+sum;
        account.setBalance(newBalance);
    }

    public void chooseOperation(){
        message.chooseOperation();
        Scanner input = new Scanner(System.in);
        var numOfOperation1 = input.nextInt();
        boolean choose = true;
        while (choose) {
            if (numOfOperation1 == 1) {
                typeOfOperation = 1;
                choose = false;
            } else if (numOfOperation1 == 2) {
                message.choosePutOrTake();
                int numOfOperation2 = input.nextInt();
                if (numOfOperation2 == 1) {
                    typeOfOperation = 21;
                    choose = false;
                } else if (numOfOperation2 == 2) {
                    typeOfOperation = 22;
                    choose = false;
                }
            } else {
                message.typeOperation();
            }
        }
    }
    public void doOperation(){
        if (typeOfOperation == 1){
            message.balance(account.getBalance());
        } else if (typeOfOperation == 21) {
            message.sumTake();
            double sum = checkSum();
            while (sum > account.getBalance()) {
                message.noMoney(sum, account.getBalance());
                sum = checkSum();
            }
            try {
                setBalanceTake(sum);
                message.balanceAfterTake(account.getBalance());
            }catch (NoMoneyException e){
                System.out.println(message.balanceError());
            }
        }else if (typeOfOperation == 22) {
            message.sumPut();
            double sum = checkSum();
            setBalancePut(sum);
            message.balanceAfterPut(account.getBalance());
        }
    }
    public double checkSum(){
        Scanner input = new Scanner(System.in);
        double sum = input.nextDouble();
        while (sum % 100 != 0){
            message.sumMastBe();
            sum = input.nextDouble();
        }
        return sum;
    }
    public void setBalanceTake(double sum) throws NoMoneyException {
        if (account.getBalance() > sum) {
            account.setBalance(account.getBalance() - sum);
        } else {
            throw new NoMoneyException(message.balanceError());
        }
    }

        public void checkServerNumber () throws ServerNotFoundException {
            message.hello();
            Scanner input = new Scanner(System.in);//вводим номер сервера
            int serverNumber = input.nextInt();
            if (serverNumber == this.server) {
                message.serverConnect();
            } else {
                throw new ServerNotFoundException(message.serverError());
            }
        }

    public int getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(int typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }
}
