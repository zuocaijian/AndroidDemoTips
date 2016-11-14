package zcj.android.activitytransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    public static final String TRASITION_TYPE = "transition_type";

    private Button btn0, btn1, btn2, btn3, btn4, btn5;

    private Button mShareBtn;

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        initData();
    }

    private void initView() {
        btn0 = (Button) findViewById(R.id.btn_type0);
        btn1 = (Button) findViewById(R.id.btn_type1);
        btn2 = (Button) findViewById(R.id.btn_type2);
        btn3 = (Button) findViewById(R.id.btn_type3);
        btn4 = (Button) findViewById(R.id.btn_type4);
        btn5 = (Button) findViewById(R.id.btn_type5);

        mShareBtn = (Button) findViewById(R.id.share_btn);
    }

    private void initListener() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    private void initData() {
        mIntent = new Intent(this, ActivitySecond.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_type0:
                openSecondActivityByType0();
                break;
            case R.id.btn_type1:
                openSecondActivityByType1();
                break;
            case R.id.btn_type2:
                openSecondActivityByType2();
                break;
            case R.id.btn_type3:
                openSecondActivityByType3();
                break;
            case R.id.btn_type4:
                openSecondActivityByType4();
                break;
            case R.id.btn_type5:
                openSecondActivityByType5();
                break;
            default:
                break;
        }
    }

    //android5.0以下转场动画
    //ActivitySecond从左侧进入，MainActivity从右侧退出
    private void openSecondActivityByType0() {
        startActivity(mIntent);
        overridePendingTransition(R.anim.anim_activity_enter_translate, R.anim.anim_activity_exit_translate);
    }

    //分解
    private void openSecondActivityByType1() {
        mIntent.putExtra(TRASITION_TYPE, 1);
        if (Build.VERSION.SDK_INT >= 21) {
            startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else if (Build.VERSION.SDK_INT >= 16) {
            startActivity(mIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    //滑动进入
    private void openSecondActivityByType2() {
        mIntent.putExtra(TRASITION_TYPE, 2);
        if (Build.VERSION.SDK_INT >= 22) {
            startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else if (Build.VERSION.SDK_INT >= 16) {
            startActivity(mIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    //淡入淡出
    private void openSecondActivityByType3() {
        mIntent.putExtra(TRASITION_TYPE, 3);
        if (Build.VERSION.SDK_INT >= 21) {
            startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else if (Build.VERSION.SDK_INT >= 16) {
            startActivity(mIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    //共享元素动画（1个）
    //两个Activity的布局文件中均有一个<? extend View>, 且在xml中设置好android:transitionName="xxx"
    private void openSecondActivityByType4() {
        mIntent.putExtra(TRASITION_TYPE, 4);
        if (Build.VERSION.SDK_INT >= 21) {
            startActivity(mIntent, ActivityOptions.makeSceneTransitionAnimation(this, mShareBtn, "shareBtn").toBundle());
        } else if (Build.VERSION.SDK_INT >= 16) {
            startActivity(mIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, mShareBtn, "shareBtn").toBundle());
        }
    }

    private void openSecondActivityByType5() {

    }
}
