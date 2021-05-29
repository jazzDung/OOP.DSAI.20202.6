package Matrix;

import javax.swing.JFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OutputScreenController {
	
	protected JFrame stage;
	protected TruthTable table;
	protected Stage demostage;

	public OutputScreenController(TruthTable table, JFrame stage) {
		
		super();
		this.table = table;
		this.stage = stage;
		
	}
	
	@FXML
	private TableView<TruthTable> Table;
	@FXML
	private TableColumn<TruthTable, String> Group;
	@FXML
	
	private void initialize() {
		Group.setCellValueFactory(new PropertyValueFactory<TruthTable, String>("Values"));
		Table.setItems(FXCollections.observableArrayList(table));
		
		addIntermediateColumn (table, demostage);
		addIntermediateColumn (table, demostage);
	}
	
	public ObservableList<TruthTable> getTruthTable(){
		ObservableList<TruthTable> observabletable = FXCollections.observableArrayList(table);
		return observabletable;
	}
	

	  public void addIntermediateColumn (TruthTable table, Stage stage) {
	
	    TableView tableView = new TableView();
	
	    TableColumn<TruthTable, String> Group = new TableColumn<>("First Name");
	    Group.setCellValueFactory(new PropertyValueFactory<TruthTable, String>("Values"));
	
	
	    tableView.getColumns().add(Group);
	
	    VBox vbox = new VBox(tableView);
	
	    Scene scene = new Scene(vbox);
	    
	    stage.setScene(scene);
	  }
	
	
}
