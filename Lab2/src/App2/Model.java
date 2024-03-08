package App2;

import java.util.Observable;

public class Model extends Observable {
    private int[] progressValues;
    public Model(int nrThreads){
        progressValues = new int[nrThreads];
    }

    public void setProgressValues(int id, int val){
        if(id >= 0 && id < progressValues.length){
            progressValues[id] = val;
            setChanged();
            notifyObservers(id);
        }
    }

    public int getProgressValue(int id){
        if(id >= 0 && id < progressValues.length){
            return progressValues[id];
        }
        return 0;
    }
}
