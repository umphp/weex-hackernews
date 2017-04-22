package com.example.weex.hackernews;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXRenderErrorCode;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXSoInstallMgrSdk;

public class MainActivity extends Activity implements IWXRenderListener {

    private WXSDKInstance mWXSDKInstance;

    private TextView mTipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mTipView = (TextView) findViewById(R.id.index_tip);

        if (!WXSoInstallMgrSdk.isCPUSupport()) {
            mTipView.setText(R.string.cpu_not_support_tip);
            return;
        }


        mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);

        mWXSDKInstance.render(WXFileUtils.loadAsset("index.js", this));
    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        setContentView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
        mTipView.setVisibility(View.GONE);
    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {
        mTipView.setVisibility(View.VISIBLE);
        if (TextUtils.equals(errCode, WXRenderErrorCode.WX_NETWORK_ERROR)) {
            mTipView.setText(R.string.index_tip);
        } else {
            mTipView.setText("render error:" + errCode + ", msg:" + msg);
        }
    }

    public void onBackPressed(){
        Log.e("USER ACTION", "BACK");
        mWXSDKInstance.fireEvent("_root","androidback");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityDestroy();
        }
    }
}

