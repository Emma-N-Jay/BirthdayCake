package cs301.birthdaycake;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.WindowDecorActionBar;
//, SeekBar.OnSeekBarChangeListener
//test
public class EventHandler implements View.OnClickListener, View.OnTouchListener {

    private MainActivity myActivity;

    //constructor requires aMainActivity to find by ID
    public EventHandler(MainActivity initActivity) {
        myActivity = initActivity;
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            Button clickedButton = (Button) v;
            String buttonLabel = clickedButton.getText().toString();
            if (buttonLabel.equalsIgnoreCase("Blow Out")) {
                //changeName();
            }
        }



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
