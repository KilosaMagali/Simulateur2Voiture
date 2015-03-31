package AppliSimu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gassama on 31/03/15.
 */
public class Route extends JComponent{

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Route(int x1, int x2, int width, int height) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = width;
        this.y2 = height;
    }

    @Override
    public  void paint(Graphics graphics){
        super.paint(graphics);
        dessinerRoute(graphics);
    }

    private void dessinerRoute(Graphics contexteGraphique) {
        contexteGraphique.setColor(Color.black);
        contexteGraphique.fillRect(x1,x2,y1,y2);
    }

}
