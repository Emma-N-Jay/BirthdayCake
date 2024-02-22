package cs301.birthdaycake;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.WindowDecorActionBar;
//, SeekBar.OnSeekBarChangeListener
public class EventHandler implements View.OnClickListener {

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
}
