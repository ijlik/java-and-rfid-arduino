package view;

public abstract class View extends javax.swing.JFrame {
    protected final String title = "e-Stafed Apps";
    public View(){
        setTitle(title);
    }
    
    protected abstract void disableMenu();
}
