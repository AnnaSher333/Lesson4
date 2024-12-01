package Ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator pinValidator;
    Message message = new Message();

    public TerminalImpl() {
        server = new TerminalServer();
        pinValidator = new PinValidator();
    }
    public void start() {
        try {
            server.checkServerNumber();
            int[] pin = pinValidator.checkPinIsDigit();
            boolean check  = true;
            while (check) {
                if (pinValidator.acceptPin(pin)) {
                    operation();
                    check = false;
                } else {
                        int count = 1;
                        while (count < 3) {
                            pin = pinValidator.checkPinIsDigit();
                            count++;
                        }
                        message.pinErrorSecond();
                        Lock lock = new Lock();
                        lock.start();

                    }
                }

            } catch(ServerNotFoundException e){
                System.out.println(message.serverError());
            }
        }

        @Override
        public double getBalance () {
            return server.getBalance();
        }
        @Override
        public void operation (){
            server.chooseOperation();
            server.doOperation();
        }
    }

