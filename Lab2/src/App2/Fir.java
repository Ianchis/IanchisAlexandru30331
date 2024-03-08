package App2;

public class Fir extends Thread{
    int id;
    Controller controller;
    int processorLoad;
    Fir(int id,int priority,Controller controller,int procLoad){
        this.id = id;
        this.controller = controller;
        this.processorLoad = procLoad;
        this.setPriority(priority);
    }

    public void run(){
        int c = 0;
        while(c<1000){
            for(int j = 0; j<this.processorLoad;j++){
                j++;
                j--;
            }
            c++;
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.controller.setProgressValue(id,c);
        }
    }
}
