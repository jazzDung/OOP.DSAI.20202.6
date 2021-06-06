package screen;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import table.TruthTable;

public class ThreeVariableScreen extends JFrame {

	public static JFXPanel fxPanel;


	public ThreeVariableScreen() {
		
		super();
	
        Dimension d = new Dimension(900, 400);
		
		fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("3 Variable Truth Table");
		this.setVisible(true);
		this.setSize(d);
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/screen/new_3_Variable.fxml"));
					ThreeVariableScreenController controller = new ThreeVariableScreenController();
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root, 1000, 800));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		new ThreeVariableScreen();
	}
	
}

