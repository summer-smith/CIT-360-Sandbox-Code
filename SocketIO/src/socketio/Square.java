package socketio;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * GUI for each square in the board
 * @author Summer
 */
public class Square extends JPanel{
    JLabel label = new JLabel((Icon)null);
    
    public Square() {
        setBackground(Color.white);
        add(label);
    }
    
    public void setIcon(Icon icon) {
        label.setIcon(icon);
    }
}
