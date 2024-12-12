package Ex2;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class Content {
    private boolean run;
    public Content(){
        run = true;
    }
    public void readContent(String url) throws URISyntaxException {
        try{
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
            run = false;
        } catch (IOException e) {
            System.out.println("IOE Введен некорректный url");
        } catch (URISyntaxException e) {
            System.out.println("URISE Введен некорректный url");
        }

    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
