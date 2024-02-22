package cs301.birthdaycake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class CakeView extends SurfaceView {

    /* These are the paints we'll use to draw the birthday cake below */
    Paint cakePaint = new Paint();
    Paint frostingPaint = new Paint();
    Paint candlePaint = new Paint();
    Paint outerFlamePaint = new Paint();
    Paint innerFlamePaint = new Paint();
    Paint wickPaint = new Paint();


    /* These constants define the dimensions of the cake.  While defining constants for things
        like this is good practice, we could be calculating these better by detecting
        and adapting to different tablets' screen sizes and resolutions.  I've deliberately
        stuck with hard-coded values here to ease the introduction for CS371 students.
     */
    public static final float cakeTop = 400.0f;
    public static final float cakeLeft = 100.0f;
    public static final float cakeWidth = 1200.0f;
    public static final float layerHeight = 200.0f;
    public static final float frostHeight = 50.0f;
    public static final float candleHeight = 300.0f;
    public static final float candleWidth = 70.0f;
    public static final float wickHeight = 30.0f;
    public static final float wickWidth = 6.0f;
    public static final float outerFlameRadius = 30.0f;
    public static final float innerFlameRadius = 15.0f;
    private CakeModel cakeModel;

    /**
     * ctor must be overridden here as per standard Java inheritance practice.  We need it
     * anyway to initialize the member variables
     */

    public CakeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //instance of a cakeModel
        cakeModel = new CakeModel();

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        //Setup our palette
        cakePaint.setColor(0xFF55CBCD);  //magenta
        cakePaint.setStyle(Paint.Style.FILL);
        frostingPaint.setColor(0xFFFFFACD);  //pale yellow
        frostingPaint.setStyle(Paint.Style.FILL);
        candlePaint.setColor(0xFF32CD32);  //lime green
        candlePaint.setStyle(Paint.Style.FILL);
        outerFlamePaint.setColor(0xFFFFD700);  //gold yellow
        outerFlamePaint.setStyle(Paint.Style.FILL);
        innerFlamePaint.setColor(0xFFFFA500);  //orange
        innerFlamePaint.setStyle(Paint.Style.FILL);
        wickPaint.setColor(Color.BLACK);
        wickPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.WHITE);  //better than black default

    }

    /**
     * draws a candle at a specified position.  Important:  the left, bottom coordinates specify
     * the position of the bottom left corner of the candle
     */
    public void drawCandle(Canvas canvas, float left, float bottom) {
        canvas.drawRect(left, bottom - candleHeight, left + candleWidth, bottom, candlePaint);
        if (cakeModel.lit) {  //draw the outer flame
            float flameCenterX = left + candleWidth / 2;
            float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius / 3;
            canvas.drawCircle(flameCenterX, flameCenterY, outerFlameRadius, outerFlamePaint);

            //draw the inner flame
            flameCenterY += outerFlameRadius / 3;
            canvas.drawCircle(flameCenterX, flameCenterY, innerFlameRadius, innerFlamePaint);}

        if (cakeModel.candles) {//draw the wick
            float wickLeft = left + candleWidth / 2 - wickWidth / 2;
            float wickTop = bottom - wickHeight - candleHeight;
            canvas.drawRect(wickLeft, wickTop, wickLeft + wickWidth, wickTop + wickHeight, wickPaint);}


    }


    /**
     * onDraw is like "paint" in a regular Java program.  While a Canvas is
     * conceptually similar to a Graphics in javax.swing, the implementation has
     * many subtle differences.  Show care and read the documentation.
     *
     * This method will draw a birthday cake
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        //top and bottom are used to keep a running tally as we progress down the cake layers
        float top = cakeTop;
        float bottom = cakeTop + frostHeight;

        //Frosting on top
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        top += layerHeight;
        bottom += frostHeight;

        //Then a second frosting layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a second cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        if (cakeModel.candles) { //Now a candle in the center
//            if(cakeModel.numCandles == 0){
//
//            }else if(cakeModel.numCandles == 1){
//                drawCandle(canvas, cakeLeft + cakeWidth/2 , cakeTop);
//
//            }else if(cakeModel.numCandles == 2){
//                drawCandle(canvas, cakeLeft + cakeWidth/2 + 4*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 - 4*candleWidth, cakeTop);
//
//            }else if(cakeModel.numCandles == 3){
//                drawCandle(canvas, cakeLeft + cakeWidth/2 + 4*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 - 4*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2, cakeTop);
//
//            }else if(cakeModel.numCandles == 4){
//                drawCandle(canvas, cakeLeft + cakeWidth/2 + 2*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 - 2*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 + 6*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 - 6*candleWidth, cakeTop);
//
//            }else if(cakeModel.numCandles == 5){
//                drawCandle(canvas, cakeLeft + cakeWidth/2 + 4*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 - 4*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 + 8*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 - 8*candleWidth, cakeTop);
//                drawCandle(canvas, cakeLeft + cakeWidth/2 , cakeTop);
//            }
            //Now a candle in the center
            if (cakeModel.numCandles == 1 || cakeModel.numCandles == 3 || cakeModel.numCandles == 5) {
                drawCandle(canvas, (cakeWidth + cakeLeft )/ 2 , cakeTop);
            }
            if (cakeModel.numCandles == 2 || cakeModel.numCandles == 4 || cakeModel.numCandles == 3) {
                drawCandle(canvas, (cakeWidth + cakeWidth) / 3, cakeTop);
                drawCandle(canvas, cakeLeft * 2 + cakeWidth / 4 - candleWidth / 4, cakeTop);
            }
            if (cakeModel.numCandles == 4 || cakeModel.numCandles == 5) {
                drawCandle(canvas, (cakeWidth + cakeLeft) / 5, cakeTop);
                drawCandle(canvas, (2 * cakeWidth) / 2 - cakeLeft, cakeTop);
            }
            if (cakeModel.numCandles == 5) {
                drawCandle(canvas, (cakeWidth + cakeWidth) / 3 + cakeLeft, cakeTop);
                drawCandle(canvas, cakeLeft * 2 + cakeWidth / 4 - candleWidth - cakeLeft/ 4, cakeTop);
            }
           }
        Paint location = new Paint();
        location.setTextSize(50);
        location.setColor(Color.RED);
        canvas.drawText(cakeModel.boxX + " , " + cakeModel.boxY, 1500, 600, location);




        //draw the boxes
        canvas.drawRect(cakeModel.boxX, cakeModel.boxY, cakeModel.boxX + 50, cakeModel.boxY + 50, this.cakePaint);
    }//onDraw

    //draw cords



    //  Allows other objects to retrieve a reference to the CakeModel object.
    public CakeModel getModel(){
        return cakeModel;
    }



}//class CakeView

