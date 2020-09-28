/**
 * <p>ClassName</p>Square.java
 * @author Andrei Daniel Vatasescu Predi
 * <p>Date<p> 01/03/2020
 * @version 1.0.0
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the square's bounding rectangle.
 */

public class Square extends ClosedShape {
    //The side of the square
    private int side;

    /**
     * Creates a square.
     * @param type The shape type.
     * @param insertionTime is the insertion time
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param isFlashing True if the square is changing colour while moving, false otherwise.
     * @param colourTwo Second changing colour.
     */
    public  Square (String type, int insertionTime, int x, int y, int vx, int vy, int side, Color colour,
                    boolean isFilled, boolean isFlashing,Color colourTwo) {
        super (type,insertionTime, x, y, vx, vy, colour, isFilled,isFlashing,colourTwo);
        this.side = side;

    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }

    /**
     * @return the type of shape
     */
    public String getType(){
        return this.type;
    }
    /**
     * @return the width of the square
     */
    public int getWidth(){
        return side;
    }

    /**
     * @return the height of the square
     */
    public int getHeight(){
        return side;
    }


    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }
}
