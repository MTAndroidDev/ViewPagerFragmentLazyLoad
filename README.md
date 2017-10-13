## Android中ViewPager+Fragment取消(禁止)预加载延迟加载(懒加载)问题解决方案


### 用法

LazyLoadFragment是一个抽象类，可以作为BaseFragment,继承它。

 * 用 setContentView() 方法去加载要显示的布局
 * 用 viewCreate()  方法初始化 View
 * lazyLoad() 方法去加载数据、控制  View
 * stopLoad()方法可选，当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
 * createView() 方法对应 fragment 的 onCreateView() 方法
 
 ```
 package cn.bluemobi.dylan.viewpagerfragmentlazyload;
 import android.util.Log;
 /**
  * Created by yuandl on 2016-11-17.
  */
 public class Fragment1 extends LazyLoadFragment {
   
	 private AlphaChangeTextView mTextView;
   
	 @Override
    public int setContentView() {
        return R.layout.fm_layout1;
    }
   
	 @Override
    protected void createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    }
   
	 @Override
    protected void viewCreate(View view, @Nullable Bundle savedInstanceState) {
        mTextView = (AlphaChangeTextView) view.findViewById(R.id.id_tv1);
        mTextView.hide();
    }

    @Override
    protected void lazyLoad() {
        String message = "Fragment1" + (isInit ? "已经初始并已经显示给用户可以加载数据" : "没有初始化不能加载数据")+">>>>>>>>>>>>>>>>>>>";
        showToast(message);
        Log.d(TAG, message);

        mTextView.show();
    }

    @Override
    protected void stopLoad() {
        mTextView.hide();
        Log.d(TAG, "Fragment1" + "已经对用户不可见，可以停止加载数据");
    }
}
```
 
### 看效果界面

![界面](https://github.com/linglongxin24/ViewPagerFragmentLazyLoad/blob/master/screenshorts/userinterface.jpg?raw=true)
![Log](https://github.com/linglongxin24/ViewPagerFragmentLazyLoad/blob/master/screenshorts/log.png?raw=true)
