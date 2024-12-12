package Ex1;

import Ex1.Exception.AccountIsLockedException;

//блокировка на 10 секунд
public class Block implements Runnable{
    Message message = new Message();
    @Override
    public void run() {
        int ostatokSec = 10;
        int sec = 10;
        while (sec >= 0) {
            try {
                if (sec > 0) {
                    System.out.println("Блокировка завершится через: " + sec + " сек.");
                    ostatokSec = 10 - sec;
                } else {
                    message.unlock();
                }
                Thread.sleep(1000);
                sec--;
            } catch (InterruptedException e) {
                try {
                    throw new AccountIsLockedException(message.lock(ostatokSec));
                } catch (AccountIsLockedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
