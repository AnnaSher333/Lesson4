package Ex2;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class Content {
    public void readContent(String url) throws URISyntaxException {
        try{
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (IOException e) {
            System.out.println("Введен некорректный url");
        } catch (URISyntaxException e) {
            System.out.println("Введен некорректный url");
        }

    }
}
