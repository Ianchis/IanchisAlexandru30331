package App2;

import java.util.Observable; // Import Observable class
import java.util.Observer; // Import Observer interface
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Window extends JFrame implements Observer {
    private ArrayList<JProgressBar> bars = new ArrayList<>();

    public Window(int nrThreads){
        setLayout(null);
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        this.setVisible(true);
    }

    public void init(int n){
        for(int i = 0; i < n; i++){
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50,(i+1)*30,350,20);
            this.add(pb);
            this.bars.add(pb);
        }
    }

    public void setProgressValue(int id, int val){
        bars.get(id).setValue(val);
    }

    @Override
    public void update(Observable o, Object arg){
        int id = (int) arg;
        bars.get(id).setValue(((Model) o).getProgressValue(id));
    }
}