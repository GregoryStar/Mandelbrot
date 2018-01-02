/**
 * Created by F on 1/1/2018.
 */
public class MandlebrotSequence {
    private ComplexNum z0;
    private int escapeIndex = -1;
    double rMax;
    public static int maxComputation = 100;
    public MandlebrotSequence (ComplexNum z0){
        this.z0 = z0;
    }

    public int computeEscapeIndex(double rMax){
        if(this.rMax == rMax && escapeIndex != -1) {
            return escapeIndex;
        } else {
            escapeIndex = -1;
            ComplexNum currentIndex = new ComplexNum(z0.getReal(), z0.getImaginary());
            int i = 0;
            while(i < maxComputation && currentIndex.distance() < rMax){
                i++;
                currentIndex = currentIndex.multiply(currentIndex).add(z0);
            }
            if(currentIndex.distance() > rMax){
                escapeIndex = i;
            }
        }
        return escapeIndex;
    }


}
