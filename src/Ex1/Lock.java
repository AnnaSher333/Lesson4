package Ex1;

import java.util.Scanner;

public class Lock extends Thread{
    Message message = new Message();
    private  int seconds;
    public void run(){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i <= 10; i++){
            try {
                Thread.sleep(1000);
                this.seconds = i;
                if (input.hasNext()){
                    message.lock(10 - seconds);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
