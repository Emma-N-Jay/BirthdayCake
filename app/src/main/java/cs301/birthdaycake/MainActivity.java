package cs301.birthdaycake;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    CakeView bob;
    Button blowOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // Retrieve reference to the "Blow Out" button view
        blowOut = findViewById(R.id.blowout);

        // Create an instance of CakeController
        bob = findViewById(R.id.cakeview);
        CakeController robert = new CakeController(bob);

        // Set CakeController as the OnClickListener for the button
        blowOut.setOnClickListener(robert);



//awesome comment
        // Retrieve reference to the "candles" switch view
        Switch candle = findViewById(R.id.candles);

        // Set CakeController as the OnClickListener for the switch
        candle.setOnCheckedChangeListener(robert);



        // Retrieve reference to the "Blow Out" button view
        SeekBar numCandle = findViewById(R.id.numCandles);

        // Set CakeController as the OnClickListener for the button
        numCandle.setOnSeekBarChangeListener(robert);

        bob.setOnTouchListener(robert);

    }

    public void goodbye(View button) {
        System.out.println("Goodbye");
        finishAffinity();
    }

        }



