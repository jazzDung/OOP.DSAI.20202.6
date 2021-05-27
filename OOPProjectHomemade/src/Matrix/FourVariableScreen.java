package Matrix;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FourVariableScreen extends JFrame {

	protected TruthTable table;

	public FourVariableScreen(TruthTable table) {
		
		super();
		JFrame stage = this;
		this.table = table;
		
        Dimension d = new Dimension(1000,800);
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Truth Table");
		this.setVisible(true);
		this.setSize(d);
		
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/Matrix/4_Variable.fxml"));
					FourVariableScreenController controller = new FourVariableScreenController(table, stage);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root, 1000, 800));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}

