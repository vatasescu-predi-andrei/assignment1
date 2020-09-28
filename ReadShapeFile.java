
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Andrei Daniel Vatasescu Predi
 * <p>Date</p> 01/03/2020
 * @Version 1.0.0
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Circle readCircle(Scanner in) {
		int x=in.nextInt();
		int y=in.nextInt();
		int vx=in.nextInt();
		int vy=in.nextInt();
		boolean isFilled=in.nextBoolean();
		boolean isFlashing=in.nextBoolean();
		int diameter=in.nextInt();
		int R=in.nextInt();
		int G=in.nextInt();
		int B=in.nextInt();
		int insertionTime=in.nextInt();
		Color colour= Color.rgb(R,G,B);
		Color colourTwo=null;
		if(isFlashing) {
			int Red = in.nextInt();
			int Green = in.nextInt();
			int Blue = in.nextInt();
			colourTwo = Color.rgb(Red, Green, Blue);

		}

		Circle circle=new Circle("circle", insertionTime, x, y, vx, vy, diameter, colour, isFilled,isFlashing,
				colourTwo);

		return circle;
	}
	private static Oval readOval(Scanner in){
		int x=in.nextInt();
		int y=in.nextInt();
		int vx=in.nextInt();
		int vy=in.nextInt();
		boolean isFilled=in.nextBoolean();
		boolean isFlashing=in.nextBoolean();
		int width=in.nextInt();
		int height=in.nextInt();
		int R=in.nextInt();
		int G=in.nextInt();
		int B=in.nextInt();
		int insertionTime=in.nextInt();
		Color colour=Color.rgb(R,G,B);
		Color colourTwo=null;
		if(isFlashing) {
			int Red = in.nextInt();
			int Green = in.nextInt();
			int Blue = in.nextInt();
			colourTwo = Color.rgb(Red, Green, Blue);

		}

		Oval oval=new Oval("oval", insertionTime, x,y,vx, vy, width, height,colour,isFilled,isFlashing,
				colourTwo);

		return oval;

	}
	private static Square readSquare(Scanner in){
		int x=in.nextInt();
		int y=in.nextInt();
		int vx=in.nextInt();
		int vy=in.nextInt();
		boolean isFilled=in.nextBoolean();
		boolean isFlashing=in.nextBoolean();
		int side=in.nextInt();
		int R=in.nextInt();
		int G=in.nextInt();
		int B=in.nextInt();
		int insertionTime=in.nextInt();
		Color colour= Color.rgb(R,G,B);
		Color colourTwo=null;
		if(isFlashing) {
			int Red = in.nextInt();
			int Green = in.nextInt();
			int Blue = in.nextInt();
			colourTwo = Color.rgb(Red, Green, Blue);

		}

		Square square=new Square("square", insertionTime, x, y, vx, vy, side, colour, isFilled,isFlashing,
				colourTwo);

		return square;
	}
	private static Rect readRect(Scanner in){
		int x=in.nextInt();
		int y=in.nextInt();
		int vx=in.nextInt();
		int vy=in.nextInt();
		boolean isFilled=in.nextBoolean();
		boolean isFlashing=in.nextBoolean();
		int width=in.nextInt();
		int height=in.nextInt();
		int R=in.nextInt();
		int G=in.nextInt();
		int B=in.nextInt();
		int insertionTime=in.nextInt();
		Color colour=Color.rgb(R,G,B);
		Color colourTwo=null;
		if(isFlashing) {
			int Red = in.nextInt();
			int Green = in.nextInt();
			int Blue = in.nextInt();
			colourTwo = Color.rgb(Red, Green, Blue);

		}
		Rect rect=new Rect("rect", insertionTime, x,y,vx, vy, width, height,colour,isFilled,isFlashing,
				colourTwo);

		return rect;
	}
	private static Text readText(Scanner in){
		String text=in.next();
		int x=in.nextInt();
		int y=in.nextInt();
		int vx=in.nextInt();
		int vy=in.nextInt();
		boolean isFilled=in.nextBoolean();
		boolean isFlashing=in.nextBoolean();
		int maxWidth=in.nextInt();
		int R=in.nextInt();
		int G=in.nextInt();
		int B=in.nextInt();
		int insertionTime=in.nextInt();
		Color colour=Color.rgb(R,G,B);
		Color colourTwo=null;
		if(isFlashing) {
			int Red = in.nextInt();
			int Green = in.nextInt();
			int Blue = in.nextInt();
			colourTwo = Color.rgb(Red, Green, Blue);

		}
		Text textObj =new Text("text",text, insertionTime, x,y,vx, vy,maxWidth,colour,isFilled,isFlashing,
				colourTwo);

		return textObj;

	}
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
		//read in the shape files and place them on the Queue
		while(in.hasNext()) {
			String objectType=in.next();
			//for each file I am first creating the object and then placing it in the queue
			if(objectType.equals("circle")){
				Circle circle=readCircle(in);
				shapeQueue.enqueue(circle);
			}
			else if(objectType.equals("oval")){
				Oval oval=readOval(in);
				shapeQueue.enqueue(oval);
			}
			else if(objectType.equals("rect")) {
				Rect rect = readRect(in);
				shapeQueue.enqueue(rect);
			}
			else if(objectType.equals("square")) {
				Square square = readSquare(in);
				shapeQueue.enqueue(square);
			}
			else if(objectType.equals("text")){
				Text text = readText(in);
				shapeQueue.enqueue(text);
			}
		}
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename The name of the file
	 * @return The queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		File inputFile=new File(filename);
	    Scanner in = null;

	    //I have used a try and catch first and then it throws the error not found
		try{
			in=new Scanner(inputFile);
		}
		catch (FileNotFoundException e){
			System.out.println("The file does not exist or you did sth wrong"+filename);
			System.exit(0);
		}

		return ReadShapeFile.readDataFile(in);
	}
}
