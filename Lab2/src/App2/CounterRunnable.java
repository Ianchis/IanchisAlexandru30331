package App2;

public class CounterRunnable implements Runnable{
    public void run(){
        Thread t = Thread.currentThread();

        for(int i = 0; i < 20; i++){
            System.out.println(t.getName() + " i = " + i);
            try{ Thread.sleep((int)(Math.random()*1000));}
            catch (InterruptedException e){e.printStackTrace();}
        }
        System.out.println(t.getName() + "job finalized.");

    }
}
