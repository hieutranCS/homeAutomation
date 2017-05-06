package automation;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class tempControl extends Application{
	static int temp = 70;
	int inputTemp = 0;
	int holder = 0;
	BorderPane bp = new BorderPane();
	HBox hbox = new HBox();
	Label lb = new Label();
	TextField tf = new TextField();

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		lb.setText(String.valueOf(temp));
		
		tf.setOnAction(this:: simTempChange);
		
		hbox.getChildren().addAll(lb, tf);
		bp.setCenter(hbox);
		
		Scene scene = new Scene(bp, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temp Sim");
		primaryStage.show();
		
	}
	
	public void simTempChange(ActionEvent e) {
		try {
			inputTemp = Integer.parseInt(tf.getText());
			holder = temp - inputTemp;
			
		} catch(NumberFormatException z) {
			lb.setText("Not a valid input");
		}
		
		Timer timer = new Timer(); 
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if ((holder > 0) && temp != inputTemp) {
					temp--;
					
					Platform.runLater(new Runnable() {
			            public void run() {
			            	lb.setText(String.valueOf(temp));
			            	tf.clear();
			            	returnTemp();
			            }
			        });
				}
				else if ((holder < 0) && temp != inputTemp) {
					temp++;
					
					Platform.runLater(new Runnable() {
			            public void run() {
			            	lb.setText(String.valueOf(temp));
			            	tf.clear();
			            	returnTemp();
			            }
			        });
				}
				
			}

			
		}, 0, 1000); //<---- Set timer delay by thousands for seconds
		
	}
public static int returnTemp(){
	return temp;
}

}