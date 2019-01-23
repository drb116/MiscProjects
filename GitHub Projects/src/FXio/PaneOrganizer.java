/**
 * @author dburnham
 * PaneOrganizer.java
 * Jan 23, 2019
 */
package FXio;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PaneOrganizer {

	private BorderPane root;
	private Label solution;
	private RadioButton add,sub,mul,div;
	private CheckBox firstNumNeg,secondNumNeg;
	
	public PaneOrganizer() {
		root = new BorderPane();	
		calculator();
	}
	
	private void calculator() {
		HBox center = new HBox();
		
		center.setAlignment(Pos.CENTER);
		center.setSpacing(20);
		center.setPadding(new Insets(20));
	
		//Left Box has check box and drop down
		VBox left = new VBox();
		left.setSpacing(10);
		firstNumNeg = new CheckBox("Negative");
		ChoiceBox<Integer> firstNum = new ChoiceBox<Integer>();
		firstNum.getItems().addAll(0,1,2,3,4,5,6,7,8,9);
		firstNum.setValue(5);
		
		left.getChildren().addAll(firstNumNeg,firstNum);
		
		//Middle has operator radio
		VBox middle = new VBox();
		middle.setSpacing(10);
		add = new RadioButton("Add");
		sub = new RadioButton("Subtract");
		mul = new RadioButton("Multiple");
		div = new RadioButton("Divide");
		ToggleGroup operator = new ToggleGroup();
		add.setToggleGroup(operator);
		sub.setToggleGroup(operator);
		mul.setToggleGroup(operator);
		div.setToggleGroup(operator);
		add.setSelected(true);
		
		middle.getChildren().addAll(add,sub,mul,div);
		
		//Right box is the same as left, but list view
		VBox right = new VBox();
		right.setSpacing(10);
		secondNumNeg = new CheckBox("Negative");
		ComboBox<Integer> secondNum = new ComboBox<Integer>();
		secondNum.getItems().addAll(0,1,2,3,4,5,6,7,8,9);
		secondNum.setValue(5);
		right.getChildren().addAll(secondNumNeg,secondNum);
		
		center.getChildren().addAll(left,middle,right);
		
		solution = new Label("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue()));
		HBox bottom = new HBox(solution);
		bottom.setAlignment(Pos.CENTER);
		
		root.setCenter(center);
		root.setBottom(bottom);
		
		add.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		sub.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		mul.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		div.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		firstNum.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		secondNum.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		firstNumNeg.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
		secondNumNeg.setOnAction(e-> solution.setText("Answer: " 
				+ getAnswer(firstNum.getValue(),secondNum.getValue())));
	}
	
	private double getAnswer(int value, int value2) {
		if (firstNumNeg.isSelected()) value *= -1;
		if (secondNumNeg.isSelected()) value2 *= -1;
		if (add.isSelected()) return value + value2;
		if (sub.isSelected()) return value - value2;
		if (mul.isSelected()) return value * value2;
		if (value2==0) return 0;
		return (double)value / value2;
	}


	public Pane getRoot() {
		return root;
	}
}
