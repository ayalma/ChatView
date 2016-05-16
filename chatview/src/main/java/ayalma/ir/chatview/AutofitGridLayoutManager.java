package ayalma.ir.chatview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * Created by alimohammadi on 5/16/16.
 *
 * @author alimohammadi.
 */
public class AutofitGridLayoutManager extends GridLayoutManager
{

    private int mColumnWidth;
    private boolean mWidthChanged;

    public AutofitGridLayoutManager(Context context, int columnWidth)
    {
        /* Initially set spanCount to 1, will be changed automatically later. */
        super(context, 1);
        setColumnWidth(checkColumnWidth(context, columnWidth));
    }

    public AutofitGridLayoutManager(Context context, int columnWidth, int orientation, boolean reverseLayout)
    {
        /* Initially set spanCount to 1, will be changed automatically later. */
        super(context, 1, orientation, reverseLayout);
        setColumnWidth(checkColumnWidth(context, columnWidth));
    }

    private int checkColumnWidth(Context context,int columnWidth)
    {
        if (columnWidth<=0)
        {
            columnWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,72,
                   context.getResources().getDisplayMetrics());
        }

        return columnWidth;
    }

    public int getmColumnWidth() {
        return mColumnWidth;
    }

    public void setColumnWidth(int columnWidth) {
       if (columnWidth>0 && columnWidth != this.mColumnWidth)
       {
           this.mColumnWidth = columnWidth;
           mWidthChanged = true;
       }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (mWidthChanged && mColumnWidth > 0)
        {
            int totalSpace;
            if (getOrientation() == VERTICAL)
            {
                totalSpace = getWidth() - getPaddingRight() - getPaddingLeft();
            }
            else
            {
                totalSpace = getHeight() - getPaddingTop() - getPaddingBottom();
            }
            int spanCount = Math.max(1, totalSpace / mColumnWidth);
            setSpanCount(spanCount);
            mWidthChanged = false;
        }
        super.onLayoutChildren(recycler, state);
    }
}
