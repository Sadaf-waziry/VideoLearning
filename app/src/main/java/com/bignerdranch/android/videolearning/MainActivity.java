package com.bignerdranch.android.videolearning;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CrystalBall mCrystalBall = new CrystalBall();
    private TextView mAnswer;
    private Button mBtnAnswer;
    private ImageView mCrystalBallImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAnswer = (TextView) findViewById(R.id.answer);
        mBtnAnswer = (Button) findViewById(R.id.btnAnswer);
        mCrystalBallImage = (ImageView) findViewById(R.id.imageView);


        mBtnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answerLAbel = mCrystalBall.getAnAnswer();
//                mCrystalBall.mAnswers[0] ="hi";
                mAnswer.setText(answerLAbel);

                animateCrystalBall();
                animateAnswer();
                playSound();
            }
        });

//        Log.d("MainActivity", "Hello");

//        Toast welcomeToast = Toast.makeText(this, "Yay! Our Activity created.", Toast.LENGTH_LONG);
//        welcomeToast.setGravity(Gravity.TOP, 0, 0);
//        welcomeToast.show();
    }

    private void animateCrystalBall() {
        mCrystalBallImage.setImageResource(R.drawable.ball_animation);
        AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalBallImage.getDrawable();
        ballAnimation.start();
    }

    private void animateAnswer() {
        AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
        fadeInAnimation.setDuration(1500);
        fadeInAnimation.setFillAfter(true);
        mAnswer.setAnimation(fadeInAnimation);
    }

    public void playSound() {
        MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
