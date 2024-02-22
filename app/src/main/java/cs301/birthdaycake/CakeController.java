package cs301.birthdaycake;

//	Add code to the bottom of your onCreate() method in the MainActivity class that performs the following:
//a.	retrieve a reference to the “Blow Out” button view on the user interface
//b.	call the setOnClickListener() method on the button to register your CakeController object as a listener for clicks on this button


import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
//awesome comment


    private CakeView mainCakeView;

    private CakeModel mainCakeModel;

    //so we can use the main cakeview and not make a new object off it.
    public CakeController(CakeView initCakeView){
        mainCakeView = initCakeView;
        mainCakeModel = mainCakeView.getModel();


    }

    @Override
    public void onClick(View v) {
        Log.d("cake", "click!");
        mainCakeView.invalidate();
        mainCakeModel.lit = false;

        }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mainCakeModel.candles=isChecked;
        mainCakeView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mainCakeModel.numCandles=progress;
        mainCakeView.invalidate();
    }
//updateCandles
        //.getProgress()


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        mainCakeModel.boxX = x;
        mainCakeModel.boxY = y;

        mainCakeModel.drawBox = true;
        mainCakeView.invalidate();

        return false;
    }
}


