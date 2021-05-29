package screen;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import table.TruthTable;

public class OutputScreen extends JFrame {

	protected TruthTable table;
	protected JFrame stage;

	public OutputScreen(TruthTable table, JFrame stage) {
		
		super();
		this.stage = stage;
		this.table = table;
		
        Dimension d = new Dimension(1000,800);
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Output");
		this.setVisible(true);
		this.setSize(d);
		
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/Matrix/OutputScreen.fxml"));
					OutputScreenController controller = new OutputScreenController(table, stage);
					loader.setController(controller);
					Parent root = loader.load();		
					Scene scene = new Scene(root, 1000, 800);	
					fxPanel.setScene(scene);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}
