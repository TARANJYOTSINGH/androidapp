package com.apppartner.androidprogrammertest;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;


public class AnimationActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        TextView txt_animation = (TextView) findViewById(R.id.txt_animation);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Jelloween - Machinato ExtraLight.ttf");
        txt_animation .setTypeface(font);
        TextView txt_animation_bonus = (TextView) findViewById(R.id.txt_animation_bonus);
        Typeface txt = Typeface.createFromAsset(getAssets(), "fonts/Jelloween - Machinato SemiBold Italic.ttf");
        txt_animation_bonus .setTypeface(txt);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onFadeButtonClicked(View v) {
        final ImageView img = (ImageView) findViewById(R.id.imageView);
        Animation fadeOut = new AlphaAnimation(1, 0);
        Animation fadeIn =new AlphaAnimation(0,1);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);






    if(img.getVisibility() == View.INVISIBLE)
    {
        img.startAnimation(fadeIn);
        img.setVisibility(View.VISIBLE);
    }
    else if (img.getVisibility() == View.VISIBLE)
    {
        img.startAnimation(fadeOut);
        img.setVisibility(View.INVISIBLE);
    }
}

    public void onBackBtnClicked(View v){
        onBackPressed();
    }

}
