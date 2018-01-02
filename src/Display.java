import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by F on 1/1/2018.
 */
public class Display{
    public static void main(String args[]){
        final DisplayManager displayManager = new DisplayManager();
        JFrame frame = new JFrame();
        frame.setSize(displayManager.getScreenWidth(), displayManager.getScreenHeight());
        //frame.add(new PixelCanvas(displayManager));
        final JLabel container = new JLabel(new ImageIcon(displayManager.getImageData()));
        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                displayManager.click(e.getX(), e.getY());
                container.setIcon(new ImageIcon(displayManager.getImageData()));
                container.revalidate();
                container.repaint();


            }
        });
        frame.add(container);
        frame.setVisible(true);
    }
}
