import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import view.StudentManagement;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
    UIManager.setLookAndFeel( new FlatLightLaf());
     } catch( Exception ex ) {
    System.err.println( "Failed to initialize LaF" );
        }
        StudentManagement SM = new StudentManagement();
        SM.setVisible(true);
    }
    
}
