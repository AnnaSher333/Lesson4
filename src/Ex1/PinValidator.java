package Ex1;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Scanner.*;

public class PinValidator {
    private int[] pin;
    Account account = new Account();
    Message message = new Message();
    //конструктор с параметром пин, который обрабатывает ошибку, выброшенную
    //методом setPin, в случае, если пин некорректный
    public PinValidator(){
        pin = account.getPin();
    }

    public PinValidator(int pin) {
        try{
            setPin(pin);
        }catch (IncorrectPinException e){
            System.out.println(message.pinIncorrectEx());
        }
    }
    public int[] getPin() {
        return pin;
    }
    //при вводе пин идет проверка на количество символов (не более 4)
    //и проверка: является ли числом введенный символ
    //если проверка прошла, то пин присваивается,
    //если нет, то выбросится ошибка, которую перехватит конструктор
    public void setPin(int pin) throws IncorrectPinException {
        String s = Integer.toString(pin);
        char[] pinToArray = s.toCharArray();
        int[] checkedPin = new int[4];
        if (pinToArray.length > 4) {
                throw new IncorrectPinException(message.pinIncorrectEx());
        } else {
            for (int i = 0; i < checkedPin.length; i++) {
                for (int j = 0; j < pinToArray.length; j++) {
                    if (!Character.isDigit(pinToArray[j])) {
                        throw new IncorrectPinException(message.pinIncorrectEx());
                    } else {
                        checkedPin[i] = Character.getNumericValue(pinToArray[j]);
                    }
                }
            }
        }
        this.pin = checkedPin;
    }

    public boolean acceptPin(int[] checkingPin) {
        return Arrays.equals(this.pin, checkingPin);
    }
    //проверка корректности ввода пин кода пользователем
    //если корректно(нет символов и букв),то возвращает массив с 4х значным пин
    public int[] checkPinIsDigit(){
        Scanner input = new Scanner(System.in);
        int[] pinInput = new int[4];
        message.pin();
        int i = 0;
        while (i < 4) {
            String s = input.nextLine();
            while (s.length() > 1){
                message.pinErrorFirst();
                s = input.nextLine();
            }
            char ch = s.charAt(0);
            if (Character.isDigit(ch)){
                pinInput[i] = Character.getNumericValue(ch);
                i++;
            } else{
                while (!Character.isDigit(ch)) {
                    message.inputError();
                    s = input.nextLine();
                    ch = s.charAt(0);
                }
                pinInput[i] = Character.getNumericValue(ch);
                i++;
            }
        }
        return pinInput;
    }

}
