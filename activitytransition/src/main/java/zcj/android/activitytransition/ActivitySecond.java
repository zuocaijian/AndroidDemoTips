package zcj.android.activitytransition;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;

/**
 * Created by cj_zu on 2016/11/14.
 */

public class ActivitySecond extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private int mOpenType = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT > 21) {
            mOpenType = getIntent().getIntExtra(MainActivity.TRASITION_TYPE, mOpenType);

            switch (mOpenType) {
                case 1:
                    //分解
                    getWindow().setEnterTransition(new Explode().setDuration(2000));
                    getWindow().setExitTransition(new Explode().setDuration(2000));
                    break;
                case 2:
                    //滑动进入
                    getWindow().setEnterTransition(new Slide().setDuration(2000));
                    getWindow().setExitTransition(new Slide().setDuration(2000));
                    break;
                case 3:
                    //淡入淡出
                    getWindow().setEnterTransition(new Fade().setDuration(2000));
                    getWindow().setExitTransition(new Fade().setDuration(2000));
                    break;
                default:
                    break;

            }
        }

        setContentView(R.layout.activity_second);
    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
