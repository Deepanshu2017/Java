import java.applet.*;
import java.awt.*;
import java.net.*;
/*<applet code="MyApplet" width="600" height="600"></applet>*/
public class MyApplet extends Applet {
    @Override
    public void init() {
        setBackground(Color.black);
        setForeground(Color.white);
    }

    @Override
    public void paint(Graphics g) {
        URL u1 = getCodeBase();
        URL u2 = getDocumentBase();
        g.setColor(Color.green);
        g.drawOval(20, 20, 100, 100);
        g.drawString(u1 + "", 300, 300);
        g.drawString(u2 + "", 350, 350);
    }
}
