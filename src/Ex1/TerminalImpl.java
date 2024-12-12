package Ex1;

import Ex1.Exception.ServerNotFoundException;


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
            server.checkServerNumber(); //соединяемся с сервером. Вводим 111 по умолчанию
            int[] inputPin = pinValidator.takeAndCheckPin(); //Корректный пин - 1234
            while (!pinValidator.acceptPin(inputPin)){ //пока не получим верный пин
                int attempts = 1;
                while (attempts < 3){ //3 попытки ввода пин
                    if (pinValidator.acceptPin(inputPin)){
                        operation();
                        break;
                    } else {
                        message.pinIncorrect();
                        inputPin = pinValidator.takeAndCheckPin();
                        attempts++;
                    }
                }
                if (!pinValidator.acceptPin(inputPin)) { // если после 3х ппыток неверный пин
                    Thread thread = new Thread(new Block());//запускаем блокировку
                    message.pinErrorSecond();
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    inputPin = pinValidator.takeAndCheckPin();//снова вводим пин
                    //возвращаемся в цикл? если пин неверный
               }
            }
            operation(); //проводим операции, тут уже пин корректный
            } catch(ServerNotFoundException e){
                System.out.println(message.serverError());//ошибка соединения с серверос
            // если введем не 111
            }
        }

        @Override
        public double getBalance () {
            return server.getBalance();
        }
        @Override
        public void operation (){
            server.chooseOperation();//выбор операции реализован в TerminalServer
            server.doOperation();//проведение операции реализовано в TerminalServer
        }
    }

