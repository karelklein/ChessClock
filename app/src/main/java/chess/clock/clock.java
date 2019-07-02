package chess.clock;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import java.util.Locale;

public class clock extends AppCompatActivity {

    private final long START_TIME_SECONDS = 20;
    private Button timerButtonWhite;
    private CountDownTimer timerWhite;
    private boolean timerWhitePaused = true;
    private long timeLeftForWhite = START_TIME_SECONDS * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        timerButtonWhite = (Button) findViewById(R.id.timerButtonWhite);

//        timerWhite = new CountDownTimer(START_TIME_SECONDS * 1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timeLeftForWhite = millisUntilFinished;
//                updateTimeText(millisUntilFinished, timerButtonWhite);
//            }
//            @Override
//            public void onFinish() {
//                timerButtonWhite.setText("Done");
//            }
//        };

//        timerButtonWhite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View vew) {
//                if (timerWhitePaused) {
//
//                    timerWhitePaused = false;
//                } else {
//                    timerWhite.cancel();
//                    timerWhitePaused = true;
//                }
//            }
//        });
    }

    public void timerButtonWhiteClick(View view) {
        if (timerWhitePaused) {
            startTimer(timerButtonWhite, timeLeftForWhite);
            timerWhitePaused = false;
        } else {
            timerWhite.cancel();
            timerWhitePaused = true;
        }
    }

    private void startTimer(final Button button, long timeLeft) {
        timerWhite = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftForWhite = millisUntilFinished;
                updateTimeText(millisUntilFinished, button);
            }
            @Override
            public void onFinish() {
                button.setText("Done");
            }
        }.start();
    }

    private void updateTimeText(long millisLeft, Button button) {
        int minutes = (int) (millisLeft / 1000) / 60;
        int seconds = (int) (millisLeft / 1000) % 60;
        String timeRemainingString = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        button.setText(timeRemainingString);
    }
}
