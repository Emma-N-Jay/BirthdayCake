package cs301.birthdaycake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/** This class represents a single balloon on the screen */
public class Balloon {
    protected float x; // x-coord
    protected float y; // y-coord
    protected final int size = 20; // all spots are size 20
    protected Paint myPaint; // how the spot is drawn

    /** gives the spot a random colored paint */
    protected void setRandomPaint() {
        int color = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));
        myPaint = new Paint();
        myPaint.setColor(color);
    }

    /** this ctor initializes a spot with random values */
    public Balloon() {
        // place a spot in a random location
        x = (float) (Math.random() * 500) + 5;
        y = (float) (Math.random() * 500) + 5;
        setRandomPaint();
    }

    /** this ctor creates a spot at a specified location */
    public Balloon(float initX, float initY) {
        // place a spot in a random location
        x = initX;
        y = initY;
        setRandomPaint();
    }

    /** a spot knows how to draw itself on a given canvas */
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, size, myPaint);
    }


}
