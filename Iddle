import java.awt.*;
import java.awt.event.InputEvent;

public class Iddle {

    public static void main(String[] args) {
        try {
            while (true) {
                Robot r = new Robot();
                int button = InputEvent.BUTTON1_DOWN_MASK;
                System.out.println("Click");
                r.mousePress(button);
                //Thread.sleep(100);
                r.mouseRelease(button);
                Thread.sleep( 4  * 60 * 1000);
            }
        }catch (Exception error){
            error.printStackTrace();
        }
    }
}
