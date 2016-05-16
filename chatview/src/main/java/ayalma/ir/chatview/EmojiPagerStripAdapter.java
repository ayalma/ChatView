package ayalma.ir.chatview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alimohammadi on 5/16/16.
 *
 * @author alimohammadi.
 */
public class EmojiPagerStripAdapter extends PagerAdapter
{
    private List<View> viewList;
    private int[][] emojiTabs;

    public EmojiPagerStripAdapter( int[][] emojiTabs) {

        this.emojiTabs = emojiTabs;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

       RecyclerView rootView = (RecyclerView) LayoutInflater.from(container.getContext()).inflate(R.layout.cv_emoji_list,container,false);

        rootView.setAdapter(new EmojiItemRecyclerViewAdapter(emojiTabs[position][0],emojiTabs[position][1]));
        rootView.setLayoutManager(new AutofitGridLayoutManager(container.getContext(),50));

        container.addView(rootView);
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }

    @Override
    public int getCount() {
        return emojiTabs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Util.getEmijoByUnicode(emojiTabs[position][0]); // this line return first emoji as icon of tab
    }



}
