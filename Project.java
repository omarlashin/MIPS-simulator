package project;
import javax.swing.UIManager;

public class Project {
    
    public static void main(String[] args) {
        try{UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}
        catch(Exception e){}
        InputFrame IF=new InputFrame();
        IF.setVisible(true);
    }
    
}