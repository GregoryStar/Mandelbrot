import java.awt.*;

/**
 * Created by F on 1/1/2018.
 */
public class ColorMap {
    static Color pixelColor(int escapeIndex){
        /*
        Color low = new Color(255, 0, 0);
        Color high = new Color(255, 255, 0);
        int redDifference = high.getRed()-low.getRed();
        int blueDifference = high.getBlue()-low.getBlue();
        int greenDifference = high.getGreen()-low.getGreen();
        int red = low.getRed() + redDifference * (escapeIndex/100);
        int blue = low.getBlue() + blueDifference * (escapeIndex/100);
        int green = low.getGreen() + greenDifference * (escapeIndex/100);
        return new Color(red, green, blue);
        */
        Color color;
        if(escapeIndex == -1){
            color = new Color(255, 0, 0);

        } else if (escapeIndex < 2) {
            color = new Color(255, 50, 0);

        } else if (escapeIndex < 5) {
            color = new Color(255, 75, 0);

        } else if (escapeIndex < 9) {
            color = new Color(255, 100, 0);

        } else if (escapeIndex < 14) {
            color = new Color(255, 150, 0);

        } else if (escapeIndex < 20){
            color = new Color(255, 200, 0);
        } else if (escapeIndex < 27){
            color = new Color(255, 255, 0);
        } else if (escapeIndex < 35) {
            color = new Color(200, 255, 0);
        } else if (escapeIndex < 44) {
            color = new Color(150, 255, 0);
        } else if (escapeIndex < 55){
            color = new Color(100, 255, 0);
        } else {
            color = new Color(0, 255, 0);
        }
        return color;
    }
}
