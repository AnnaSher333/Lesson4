package Ex1;

import Ex1.Exception.AccountIsLockedException;
import Ex1.Exception.IncorrectPinException;

import java.util.Arrays;
import java.util.Scanner;

public class PinValidator {
    private int[] pin; //записываем вводимый пользователем пин
    Account account = new Account(); //хранит пин одного аккаунта
    Message message = new Message(); //для вывода сообщений

    public PinValidator(){
        pin = account.getPin();
    }

    public boolean acceptPin(int[] checkingPin) {
        return Arrays.equals(this.pin, checkingPin);
    }

    //проверка символа пин-кода на корректность - долна быть цифра о 0 до 9
    public boolean checkNumOfPin(String numOfPin){
        char ch = numOfPin.charAt(0);
        if (numOfPin.length() > 1) {
            message.pinErrorFirst();
            return false;
        } else if (!Character.isDigit(ch)){
            message.inputError();
            return false;
        }else
            return true;
    }
    //проверка и получение целого пин-кода
    public int[] takeAndCheckPin(){
        int[] inputPin = new int[4];
        Scanner input = new Scanner(System.in);
        message.pin();
        for (int i = 0; i < 4; i++){ //получаем пин с проверкой каждого символа
                String num = input.nextLine();
                if (checkNumOfPin(num)) {
                    inputPin[i] = Integer.parseInt(num);
                } else {
                    while (!checkNumOfPin(num)) {
                        num = input.nextLine();
                    }
                    inputPin[i] = Integer.parseInt(num);
                }
        }
        return inputPin;
    }
}


