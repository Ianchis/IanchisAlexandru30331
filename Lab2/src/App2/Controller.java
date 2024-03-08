package App2;

public class Controller {
    private Model model;
    private Window view;

    public Controller(Model model, Window view){
        this.model = model;
        this.view = view;
        this.model.addObserver(this.view);
    }


    public void setProgressValue(int id, int val){
        model.setProgressValues(id, val);
    }
}
