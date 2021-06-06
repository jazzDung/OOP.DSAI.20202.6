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

public class FourVariableScreenController {

	protected JFrame stage;
	protected TruthTable table;
	
	public FourVariableScreenController(TruthTable table, JFrame stage) {
		
		super();
		this.table = new TruthTable(4);
		this.stage = stage;
		
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
    	
    	if (this.row4.getSelectedToggle() == row40) {table.values.get(4).add("0");} else {table.values.get(4).add("1");}
    	
    	if (this.row5.getSelectedToggle() == row50) {table.values.get(5).add("0");} else {table.values.get(5).add("1");}
    	
    	if (this.row6.getSelectedToggle() == row60) {table.values.get(6).add("0");} else {table.values.get(6).add("1");}
    	
    	if (this.row7.getSelectedToggle() == row70) {table.values.get(7).add("0");} else {table.values.get(7).add("1");}
    	
    	if (this.row8.getSelectedToggle() == row80) {table.values.get(8).add("0");} else {table.values.get(8).add("1");}
    	
    	if (this.row9.getSelectedToggle() == row90) {table.values.get(9).add("0");} else {table.values.get(9).add("1");}

    	if (this.rowten.getSelectedToggle() == row100) {table.values.get(10).add("0");} else {table.values.get(10).add("1");}
    	
    	if (this.roweleven.getSelectedToggle() == row110) {table.values.get(11).add("0");} else {table.values.get(11).add("1");}
    	
    	if (this.row12.getSelectedToggle() == row120) {table.values.get(12).add("0");} else {table.values.get(12).add("1");}
    	
    	if (this.row13.getSelectedToggle() == row130) {table.values.get(13).add("0");} else {table.values.get(13).add("1");}
    	
    	if (this.row14.getSelectedToggle() == row140) {table.values.get(14).add("0");} else {table.values.get(14).add("1");}
    	
    	if (this.row15.getSelectedToggle() == row150) {table.values.get(15).add("0");} else {table.values.get(15).add("1");}

		return table;
    }

    @FXML
    private RadioButton row11;

    @FXML
    private ToggleGroup row12;

    @FXML
    private RadioButton row10;
    
    @FXML
    private ToggleGroup rowten;

    @FXML
    private ToggleGroup roweleven;

    @FXML
    private RadioButton row101;

    @FXML
    private ToggleGroup row15;

    @FXML
    private ToggleGroup row13;

    @FXML
    private ToggleGroup row14;

    @FXML
    private RadioButton row140;

    @FXML
    private RadioButton row91;

    @FXML
    private RadioButton row90;

    @FXML
    private RadioButton row51;

    @FXML
    private RadioButton row100;

    @FXML
    private RadioButton row50;

    @FXML
    private RadioButton row141;

    @FXML
    private ToggleGroup OutputType;

    @FXML
    private RadioButton row00;

    @FXML
    private RadioButton row01;

    @FXML
    private ToggleGroup row1;

    @FXML
    private ToggleGroup row0;

    @FXML
    private ToggleGroup row7;

    @FXML
    private RadioButton row80;

    @FXML
    private RadioButton row151;

    @FXML
    private ToggleGroup row6;

    @FXML
    private RadioButton row150;

    @FXML
    private RadioButton row81;

    @FXML
    private ToggleGroup row9;

    @FXML
    private ToggleGroup row8;

    @FXML
    private ToggleGroup row3;

    @FXML
    private RadioButton row40;

    @FXML
    private RadioButton row111;

    @FXML
    private ToggleGroup row2;

    @FXML
    private RadioButton row41;

    @FXML
    private RadioButton row110;

    @FXML
    private ToggleGroup row5;

    @FXML
    private ToggleGroup row4;

    @FXML
    private RadioButton POS;

    @FXML
    private RadioButton row31;

    @FXML
    private ToggleGroup row75;

    @FXML
    private Button ThreeVariable;

    @FXML
    private Button submit;

    @FXML
    private Button FourVariable;

    @FXML
    private RadioButton row70;

    @FXML
    private RadioButton row30;

    @FXML
    private ToggleGroup row74;

    @FXML
    private RadioButton row121;

    @FXML
    private RadioButton row71;

    @FXML
    private RadioButton row120;

    @FXML
    private RadioButton row20;

    @FXML
    private RadioButton row21;

    @FXML
    private RadioButton row60;

    @FXML
    private RadioButton row131;

    @FXML
    private RadioButton row61;

    @FXML
    private RadioButton row130;

    @FXML
    private RadioButton SOP;

}