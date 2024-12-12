package Ex2;

import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите url: ");
        Content content = new Content();
        while (content.isRun()) {
            try {
                content.readContent(String.valueOf(input.nextLine()));
            } catch (URISyntaxException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
