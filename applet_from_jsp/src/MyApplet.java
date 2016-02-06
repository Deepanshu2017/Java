import java.awt.*;
import java.applet.*;

/*<applet code="MyApplet" width="400" height="400"></applet>*/
public class MyApplet extends Applet {

    @Override
    public void init() {
        setBackground(Color.black);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.drawOval(20, 20, 100, 100);
    }
}