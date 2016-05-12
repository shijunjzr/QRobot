package com.byl.qrobot.ui.tab.tab3;


import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.byl.qrobot.R;
import com.byl.qrobot.config.Const;
import com.byl.qrobot.ui.base.BaseActivity;
import com.byl.qrobot.ui.tab.tab1.Tab1Activity;
import com.byl.qrobot.util.DialogUtil;
import com.byl.qrobot.util.PreferencesUtils;
import com.byl.qrobot.util.SysUtils;
import com.byl.qrobot.util.ToastUtil;


/**
 * 主程序
 */
public class Tab3Activity extends BaseActivity {

    RelativeLayout rl_msg,rl_setting,rl_about,rl_loginout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);
        setPadding(R.id.activity_tab3);
        initTitleBar("", "我的", "", null);
        initView();

    }

    private void initView() {
        rl_msg= (RelativeLayout) findViewById(R.id.rl_msg);//消息提醒
        rl_setting= (RelativeLayout) findViewById(R.id.rl_setting);//设置
        rl_about= (RelativeLayout) findViewById(R.id.rl_about);//关于
        rl_loginout= (RelativeLayout) findViewById(R.id.rl_loginout);//退出登录

        rl_msg.setOnClickListener(this);
        rl_setting.setOnClickListener(this);
        rl_about.setOnClickListener(this);
        rl_loginout.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.rl_msg:
//                ToastUtil.showToast(this,"消息提醒");
                break;
            case R.id.rl_setting:
                ToastUtil.showToast(this,"设置");
                break;
            case R.id.rl_about:
                SysUtils.startActivity(getParent(),AboutActivity.class);
                break;
            case R.id.rl_loginout:
                DialogUtil.showChooseDialog(this, "", "您确定退出吗？", null, null, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PreferencesUtils.putSharePre(Tab3Activity.this,Const.LOGIN_PWD,"");
                        getParent().finish();
                    }
                });
                break;
        }
    }
}