package cn.bluemobi.dylan.viewpagerfragmentlazyload;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * <pre>
 *     author : MTAndroidDev
 *     e-mail : ytumaotong@gmail.com
 *     time   : 2017/10/13
 *     desc   : 渐现出来的 TextView
 *     version: 1.0
 * </pre>
 */
public class AlphaChangeTextView extends android.support.v7.widget.AppCompatTextView {
    public AlphaChangeTextView(Context context) {
        super(context);
    }

    public AlphaChangeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AlphaChangeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void show(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(this,"alpha",0.0f,1.0f);
        animator.setDuration(200);
        animator.start();
    }

    public void hide(){
        setAlpha(0);
    }

}
