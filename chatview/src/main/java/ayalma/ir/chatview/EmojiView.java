package ayalma.ir.chatview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.ResultReceiver;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;

/**
 * Created by alimohammadi on 5/16/16.
 *
 * @author alimohammadi.
 */
public class EmojiView extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener {
    private Context mContext;

    public EmojiView(Context context) {
        super(context);
        initEmoji(context, null, 0);
    }

    public EmojiView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initEmoji(context, attrs, defStyleAttr);
    }

    public EmojiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initEmoji(context, attrs, 0);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public EmojiView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initEmoji(context, attrs, defStyleAttr);
    }

    private void initEmoji(Context context, AttributeSet attr, int deffAttr) {

        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.chat_view_emoji_view, (ViewGroup) getRootView(),false);

        setHeight(context.getResources().getDimensionPixelSize(R.dimen.keyboard_height_dimen));
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fefefe")));
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

        //setFocusable(true);
        setTouchable(true);

        setContentView(view);
        getRootView().getViewTreeObserver().
                addOnGlobalLayoutListener(this);

      //  setAnimationStyle(R.style.AnimationPopup);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setInputMethodMode(INPUT_METHOD_NOT_NEEDED);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED);
        setOnDismissListener(this);

        ViewPager pager = (ViewPager) view.findViewById(R.id.cv_emoji_pager);
        int[][]  emojisCode = new int[][] {{0x1F601,0x1F64F}};
        pager.setAdapter(new EmojiPagerStripAdapter(emojisCode));

        TabLayout tabs = (TabLayout) view.findViewById(R.id.cv_emoji_tabs);
        tabs.setupWithViewPager(pager);

    }

    public void show() {
      getRootView().setPadding(0,0,0,getHeight());
        showAtLocation(getContentView(), Gravity.BOTTOM,0,getNaviagarionHeight());
    }

    @Override
    public void onGlobalLayout() {
        //getRootView().
    }

    private View getRootView()
    {
        return  ((Activity)mContext).getWindow().getDecorView().getRootView();
    }

    public static void showKeyboard(View view) {
        if (view == null) {
            return;
        }
        InputMethodManager inputManager = (InputMethodManager)view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static boolean isKeyboardShowed(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        return inputManager.isActive(view);
    }

    public static void hideKeyboard(View view,ResultReceiver resultReceiver) {
        if (view == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!imm.isActive()) {
            return;
        }

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0,resultReceiver);
    }


    @Override
    public void onDismiss() {
        getRootView().setPadding(0,0,0,0);
    }

    int getNaviagarionHeight()
    {
        Resources resources = mContext.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }
}
