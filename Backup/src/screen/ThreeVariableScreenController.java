package screen;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import table.TruthTable;

public class ThreeVariableScreenController {

	protected JFrame stage;
	protected TruthTable table;
	
	public ThreeVariableScreenController(TruthTable table, JFrame stage) {
		
		super();
		this.table = new TruthTable(3);
		this.stage = stage;
		
	}
	
    @FXML
    void btnThreeVariablePressed(ActionEvent event) {
    	new ThreeVariableScreen(new TruthTable());
    	stage.dispose();
    }

    @FXML
    void btnFourVariablePressed(ActionEvent event) {
		new FourVariableScreen(new TruthTable());
    	stage.dispose();
    }
    
    @FXML 
    public TruthTable fillTruthTable() {
    	if (this.row0.getSelectedToggle() == row00) {table.values.get(0).add("0");} else {table.values.get(0).add("1");}
    	
    	if (this.row1.getSelectedToggle() == row10) {table.values.get(1).add("0");} else {table.values.get(1).add("1");}
    	
    	if (this.row2.getSelectedToggle() == row20) {table.values.get(2).add("0");} else {table.values.get(2).add("1");}
    	
    	if (this.row3.getSelectedToggle() == row30) {table.values.get(3).add("0");} else {table.values.get(3).add("1");}
    	
    	if (this.row3.getSelectedToggle() == row30) {table.values.get(3).add("0");} else {table.values.get(3).add("1");}

    	if (this.row4.getSelectedToggle() == row40) {table.values.get(4).add("0");} else {table.values.get(4).add("1");}
    	
    	if (this.row5.getSelectedToggle() == row50) {table.values.get(5).add("0");} else {table.values.get(5).add("1");}
    	
    	if (this.row6.getSelectedToggle() == row60) {table.values.get(6).add("0");} else {table.values.get(6).add("1");}
    	
    	if (this.row7.getSelectedToggle() == row70) {table.values.get(7).add("0");} else {table.values.get(7).add("1");}

		return table;
    }
    
    
    @FXML
    void btnSubmitPressed(ActionEvent event) {
    	if (this.OutputType.getSelectedToggle() == POS) {
    		fillTruthTable().NegateTable();
    		new OutputScreen(table, "POS");
    		stage.dispose();
    	}
    	else if (this.OutputType.getSelectedToggle() == SOP) {
    		fillTruthTable();
      		new OutputScreen(table, "SOP");
    		stage.dispose();
    	}
    }
    
    @FXML
    private RadioButton SOP;

    @FXML
    private RadioButton POS;
    
    @FXML
    private ToggleGroup OutputType;
    
    @FXML
    private Button FourVariable;
    
    @FXML
    private Button ThreeVariable;
    
    @FXML
    private RadioButton row11;

    @FXML
    private RadioButton row31;

    @FXML
    private RadioButton row10;

    @FXML
    private Button submit;

    @FXML
    private RadioButton row70;

    @FXML
    private RadioButton row51;

    @FXML
    private RadioButton row30;

    @FXML
    private RadioButton row71;

    @FXML
    private RadioButton row50;

    @FXML
    private RadioButton row00;

    @FXML
    private RadioButton row01;

    @FXML
    private ToggleGroup row1;

    @FXML
    private RadioButton row20;

    @FXML
    private RadioButton row21;

    @FXML
    private ToggleGroup row0;

    @FXML
    private ToggleGroup row7;

    @FXML
    private ToggleGroup row6;

    @FXML
    private ToggleGroup row3;

    @FXML
    private RadioButton row40;

    @FXML
    private ToggleGroup row2;

    @FXML
    private RadioButton row41;

    @FXML
    private ToggleGroup row5;

    @FXML
    private RadioButton row60;

    @FXML
    private ToggleGroup row4;

    @FXML
    private RadioButton row61;

}