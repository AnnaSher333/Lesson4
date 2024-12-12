package Ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account{
    private int CardNumber = 333;
    private double balance;
    private int[] pin = {1, 2 ,3 ,4};

    public Account(double balance){
        this.balance=balance;
    }
    public Account(){}

    public int getCardNumber() {return CardNumber;}
    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}

    public int[] getPin() {
        return pin;
    }

    public void setPin(int[] pin) {
        this.pin = pin;
    }
}
