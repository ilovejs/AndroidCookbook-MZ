package com.example.mz1.app;

import android.os.CountDownTimer;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by mz on 5/25/2014.
 */
public class MalibuCountDownTimer extends CountDownTimer {
    private long timeElapsed;
    private long startTime;
    private TextView timeElapsedView;
    private TextView text;

    //Provide default constructor
    public MalibuCountDownTimer(long te,
                                long st,
                                TextView tev,
                                TextView text,
                                long startTime,
                                long interval)
    {
        super(startTime, interval);
        this.timeElapsed = te;
        this.startTime = st;
        this.timeElapsedView = tev;
        this.text = text;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        text.setText("Time remain:" + millisUntilFinished);
        timeElapsed = startTime - millisUntilFinished;
        timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));
    }

    @Override
    public void onFinish() {
        text.setText("Time's up!");
        timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
    }
}
