import java.awt.*;

/**
 * Created by F on 1/1/2018.
 */
public class PixelCanvas extends Canvas {
    int width;
    int height;
    DisplayManager displayManager;
    public PixelCanvas(DisplayManager displayManager){
        this.displayManager = displayManager;
        this.width = displayManager.getScreenWidth();
        this.height = displayManager.getScreenHeight();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        int[][] pixelSet = displayManager.calculateDisplay();
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                g.setColor(ColorMap.pixelColor(pixelSet[i][j]));
                g.drawLine(i, j, i, j);
            }
        }
    }


}
