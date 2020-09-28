/**
 * <p>ClassName</p>Text.java
 * @author Andrei Daniel Vatasescu Predi
 * <p>Date<p> 01/03/2020
 * @version 1.0.0
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Text is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the texts's bounding rectangle.
 */

public class Text extends ClosedShape {
    //Text to be inserted, its maximum width and height which is constant
    private String text;
    private int maxWidth;
    private static final int HEIGHT=10;

    /**
     * Creates a text.
     * @param type The shape type.
     * @param text The text to be drawn.
     * @param insertionTime is the insertion time.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param maxWidth the width of the text.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the text is filled with colour, false if opaque.
     * @param isFlashing True if the square is changing colour while moving, false otherwise.
     * @param colourTwo Second changing colour.
     */
    public  Text (String type, String text, int insertionTime, int x, int y, int vx, int vy, int maxWidth, Color colour,
                  boolean isFilled, boolean isFlashing,Color colourTwo) {
        super (type,insertionTime, x, y, vx, vy, colour, isFilled,isFlashing,colourTwo);
        this.text = text;
        this.maxWidth=maxWidth;

    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a text\n";
        result += super.toString ();
        result += "The text is" + this.text + "\n";
        return result;
    }

    /**
     * @return The side of the square.
     */
    public double getMaxWidth() {
        return maxWidth;
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
        return maxWidth;
    }

    /**
     * @return the height of the square
     */
    public int getHeight(){
        return HEIGHT;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillText( text,x, y,maxWidth );
        }
        else {
            g.strokeText( text,x, y,maxWidth );
        }
    }
}
