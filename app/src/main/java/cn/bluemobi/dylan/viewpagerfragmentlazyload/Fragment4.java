package cn.bluemobi.dylan.viewpagerfragmentlazyload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yuandl on 2016-11-17.
 */

public class Fragment4 extends LazyLoadFragment {

    private AlphaChangeTextView mTextView;
    @Override
    public int setContentView() {
        return R.layout.fm_layout4;
    }

    @Override
    protected void createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void viewCreate(View view, @Nullable Bundle savedInstanceState) {
        mTextView = (AlphaChangeTextView) view.findViewById(R.id.id_tv4);
        mTextView.hide();
    }

    @Override
    protected void lazyLoad() {
        String message = "Fragment4" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);

        mTextView.show();
    }
    @Override
    protected void stopLoad() {
        Log.d(TAG, "Fragment4" + "已经对用户不可见，可以停止加载数据");
        mTextView.hide();
    }
}
