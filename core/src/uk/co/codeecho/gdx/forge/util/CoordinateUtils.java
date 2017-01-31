package uk.co.codeecho.gdx.forge.util;

import com.badlogic.gdx.math.Rectangle;

public class CoordinateUtils {

    public static void recalculateRectangleAroundCentralCoordinates(Rectangle rectangle){
        rectangle.x = rectangle.x + (rectangle.width/2);
        rectangle.y = rectangle.y + (rectangle.height/2);
    }
    
    public static void recalculateRectangleAroundBottomLeftCoordinates(Rectangle rectangle){
        rectangle.x = rectangle.x - (rectangle.width/2);
        rectangle.y = rectangle.y - (rectangle.height/2);
    }
    
}
