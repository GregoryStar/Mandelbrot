/**
 * Created by F on 1/2/2018.
 */
public class MandlebrotThread extends Thread {
    MandlebrotSequence sequence;
    int[][] escapeIndices;
    int i;
    int j;

    public MandlebrotThread(MandlebrotSequence sequence, int[][] escapeIndices, int i, int j){
        this.sequence = sequence;
        this.escapeIndices = escapeIndices;
        this.i = i;
        this.j = j;
    }

    @Override
    public void run(){
        escapeIndices[i][j] = sequence.computeEscapeIndex(2);
    }
}
