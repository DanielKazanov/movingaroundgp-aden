import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class MovingAroundGridPane. This class provides an example of how
 * to move items around in a GridPane
 */
public class MovingAroundGridPane extends Application {
	
	/** The t 4. */
	private Polygon t1, t2, t3, t4;   // t1 up, t2 right, t3 down, t4 left
	
	/** The pane. */
	private BorderPane pane;
	
	/** The sp. */
	private StackPane sp;
	
	/** The gp. */
	private GridPane gp;
	
	/** The Constant MAX_X_CELLS. */
	private static final int MAX_X_CELLS = 8;
	
	/** The Constant MAX_Y_CELLS. */
	private static final int MAX_Y_CELLS = 10;

	/** The Constant MOVE_RIGHT. */
	private static final int MOVE_RIGHT = 0;
	
	/** The Constant MOVE_DOWN. */
	private static final int MOVE_DOWN = 1;
	
	/** The Constant MOVE_LEFT. */
	private static final int MOVE_LEFT = 2;
	
	/** The Constant MOVE_UP. */
	private static final int MOVE_UP = 3;
	
	/** The curr state. */
	private int currState=MOVE_RIGHT;
	
	/** The next state. - initialized to an INVALID state */
	private int nextState=-1;

	/** The cell X. */
	private int cellX = 0;
	
	/** The cell Y. */
	private int cellY = 0;

	/** The t. */
	private Timeline t;
	
	/** The time. */
	private int time = 0;
	
	/** The duration. */
	private int duration = 1000;  
	
	/** The label to display duration. */
	private Label lblDuration = new Label("Duration = "+duration);
	
	/**
	 * Starts the GUI. Initializes the various containers and shapes.
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		pane = new BorderPane();
		sp = new StackPane();
		// Create the triangles
		makeTriangles();	
		sp.getChildren().addAll(t1,t2,t3,t4);
		gp = new GridPane();
		
		setGridPaneConstraints();
		
		gp.add(sp,cellX,cellY);
		pane.setCenter(gp);
		
		HBox btnBox = new HBox(15);
		Button stop = new Button("Stop");
		Button run = new Button("Run");
		Button speedup = new Button("Faster");
		Button slowdown = new Button("Slower");
		stop.setOnAction(e -> t.pause());
		run.setOnAction(e -> {t.setCycleCount(Animation.INDEFINITE); t.play();});
		speedup.setOnAction(e -> changeSpeed(true));
		slowdown.setOnAction(e -> changeSpeed(false));
        btnBox.getChildren().addAll(run,stop,speedup, slowdown, lblDuration);
        pane.setBottom(btnBox);  
        initTimeline();
 		Scene scene = new Scene(pane,400,600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Moving Around A GridPane");
		primaryStage.show();
	}
	
	/**
	 * ChangeSpeed. Actions:
	 * 1) pause the current timeline if running. Compare status of timeline to
	 *    Animation.Status.RUNNING
	 * 2) if faster, divide the duration by 2 (USE BITWISE OPERATORS!)
	 *    is not faster, multiply the duration by 2 (USE BITWISE OPERATORS!)
	 * 3) initialize the timeline
	 * 4) if the timeline was running, restart it
	 *
	 * @param faster the faster
	 */
	private void changeSpeed(boolean faster) {
		//TODO: Code this method
	}
	
	/**
	 * Creates a new timeline. Configure the timeline as follows:
	 *      create a new KeyFrame with Duration = duration and
	 *      	                       stepSim() as the event handler
	 *      set the timeline cycle count to Animation.INDEFINITE
	 *      set the text in lblDuration to reflect the current duration
	 */
	private void initTimeline() {
		//TODO: Code this method
	}
	
	/**
	 * Sets the grid pane constraints. Each cell will be set to 50x50 pixels
	 */
	public void setGridPaneConstraints() {
		for (int i = 0; i < MAX_X_CELLS; i ++) 
			gp.getColumnConstraints().add(new ColumnConstraints(50));

		for (int i = 0; i < MAX_Y_CELLS; i ++) 
			gp.getRowConstraints().add(new RowConstraints(50));
	}
	
	/**
	 * Make Equilateral Triangles using Polygons. Make one, then use those
	 * points and rotation to create 3 other orientations that are multiples of
	 * 90 degrees apart (to represent up, down, left and right movement). 
	 * The default triangle will be placed in 0,0 (top left corner) so will
	 * be moving right - make this one visible and all others invisible
	 */
	public void makeTriangles() {
		t1 = new Polygon();  //Up
		t1.getPoints().addAll(5.0,20.0,25.0,20.0,15.0,20-10*Math.pow(3,0.5));
		t1.setStroke(Color.RED);
		t1.setStrokeWidth(2);
		t1.setFill(Color.RED);
		t2 = new Polygon();  // Right
		t2.getPoints().addAll(t1.getPoints());
		t2.setRotate(90);
		t2.setStroke(Color.CYAN);
		t2.setStrokeWidth(2);
		t2.setFill(Color.CYAN);
		t3 = new Polygon(); // Down
		t3.getPoints().addAll(t1.getPoints());
		t3.setRotate(180);
		t3.setStroke(Color.PURPLE);
		t3.setStrokeWidth(2);
		t3.setFill(Color.PURPLE);
		t4 = new Polygon();  //Left
		t4.getPoints().addAll(t1.getPoints());
		t4.setRotate(270);
		t4.setStroke(Color.GREEN);
		t4.setStrokeWidth(2);
		t4.setFill(Color.GREEN);
		t1.setVisible(false);
		t2.setVisible(true);
		t3.setVisible(false);
		t4.setVisible(false);
	}

	/**
	 * Move right. Increment the X location by one
	 *
	 * @return the next state - either MOVE_RIGHT or MOVE_DOWN
	 */
	private int moveRight() {
		//TODO: Implement this method
		return -1;
	}
	
	/**
	 * Move down. Increments the Y location by one
	 *
	 * @return the next state - either MOVE_DOWN or MOVE_LEFT
	 */
	private int moveDown() {
		//TODO: Implement this method
		return -1;
	}
	
	/**
	 * Move left. Decrements the X location by one
	 *
	 * @return the next state - either MOVE_LEFT or MOVE_UP
	 */
	private int moveLeft() {
		//TODO: Implement this method
		return -1;
	}
	
	/**
	 * Move up. Decrements the Y location by one
	 *
	 * @return the next state - either MOVE_UP or MOVE_RIGHT
	 */
	private int moveUp() {
		//TODO: Implement this method
		return -1;
	}
		
	
	/**
	 * Step sim. This will implement the FSM as follows:
	 * 1. Calculate the next state based upon the current state.
	 *    This should be implemented as a switch statement based upon
	 *    current state. The appropriate state method will be called, and
	 *    the calculated next state returned.
	 * 2. Update the Gridpane. This will move the stackpane sp to the next
	 *    GridPane cell, and adjust the triangle if necessary
	 * 3. Update current state to the next state...
	 */
	private void stepSim() {
		// TODO: Code this method. Assume that at time == 0, triangle is
		//       in top left GridPane cell, facing right.

	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	

}
