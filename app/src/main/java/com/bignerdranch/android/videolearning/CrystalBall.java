package com.bignerdranch.android.videolearning;

import java.util.Random;

/**
 * Created by netlinks on 4/25/16.
 */
public class CrystalBall {

    String[] mAnswers ={
            "In regard to this question",
            "hold that He must have ",
            "Realities, and no change",
            "are still and silent",
            "spring came",
            "in Persian and Arabic",
            "They are eloquent"
    };

    public String getAnAnswer(){
        String answerLAbel = "";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mAnswers.length);
        answerLAbel = mAnswers[randomNumber];
        return answerLAbel;
    }
}
