import java.awt.image.BufferedImage;

/**
 * Created by F on 1/1/2018.
 */
public class DisplayManager {
    double maxReal = 2;
    double minReal = -2;
    double maxImag = 2;
    double minImag = -2;
    int screenWidth = 1000;
    int screenHeight = 1000;
    int[][] complexPlane;
    BufferedImage imagedata = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);

    public int[][] calculateDisplay(){
        complexPlane = new int[screenWidth][screenHeight];
        MandlebrotThread[][] threads = new MandlebrotThread[screenWidth][screenHeight];
        for(int i = 0; i < complexPlane.length; i++){
            for(int j = 0; j < complexPlane[i].length; j++){
                MandlebrotSequence sequence = new MandlebrotSequence(mapPixelToComplex(i, j));
                complexPlane[i][j] = sequence.computeEscapeIndex(2);
                imagedata.setRGB(i, j, ColorMap.pixelColor(complexPlane[i][j]).getRGB());
                //threads[i][j] = new MandlebrotThread(new MandlebrotSequence(mapPixelToComplex(i, j)), complexPlane, i, j);
                //threads[i][j].run();
            }
        }
        return complexPlane;
    }

    public BufferedImage getImageData(){
        calculateDisplay();
        return imagedata;
    }

    private ComplexNum mapPixelToComplex(double x, double y){
        double real = minReal + x * (maxReal - minReal)/screenWidth;
        double imag = minImag + y * (maxImag - minImag)/screenHeight;
        return new ComplexNum(real, imag);
    }

    public int getScreenWidth(){
        return screenWidth;
    }

    public int getScreenHeight(){
        return screenHeight;
    }

    public void click(int x, int y){
        //translate the coordinates, then zoom
        int xScreenOffset = x - (screenWidth/2);
        int yScreenOffset = y - (screenHeight/2);
        double realDist = maxReal - minReal;
        double imagDist = maxImag - minImag;
        minReal += xScreenOffset * (realDist/screenWidth);
        minImag += yScreenOffset * (imagDist/screenHeight);
        maxReal = minReal + realDist;
        maxImag = minImag + imagDist;
        maxReal /= 2;
        minReal /= 2;
        maxImag /= 2;
        minImag /= 2;
    }

}
