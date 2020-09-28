/**
 * Rect.java
 * @author Andrei Daniel Vatasescu Predi
 * <p>Date<p> 01/03/2020
 * @version 1.0.0
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Rectangle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the rectangle's bounding rectangle.
 */

public class Rect extends ClosedShape {
    //The width and height of the Rectangle
    private int width;
    private int height;

    /**
     * Creates a rectangle.
     * @param type The shape type
     * @param insertionTime is the insertion time
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     * @param isFlashing True if the rectangle is changing colour while moving, false otherwise
     * @param colourTwo Second changing colour
     */
    public  Rect (String type, int insertionTime, int x, int y, int vx, int vy, int width,int height, Color colour,
                  boolean isFilled,boolean isFlashing,Color colourTwo) {
        super (type,insertionTime, x, y, vx, vy, colour, isFilled,isFlashing,colourTwo);
        this.width = width;
        this.height=height;

    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its width is " + this.width + "\n";
        result += "Its height is " + this.height + "\n";
        return result;
    }

    /**
     * @return The width of the rectangle.
     */
    public int getWidth() {
        return width;
    }
    /**
     * @return The height of the rectangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the type of shape
     */
    public String getType(){
        return this.type;
    }

    /**
     * Draw the rectangle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.strokeRect( x, y, width, height );
        }
    }
}
