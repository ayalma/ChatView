package ayalma.ir.chatview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alimohammadi on 5/16/16.
 *
 * @author alimohammadi.
 */
public class EmojiItemRecyclerViewAdapter extends RecyclerView.Adapter<EmojiItemRecyclerViewAdapter.EmojiItemHolder>
{
    int start,end;

    public EmojiItemRecyclerViewAdapter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public EmojiItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.emoji_list_content,parent,false);
        return new EmojiItemHolder(rootView);
    }

    @Override
    public void onBindViewHolder(EmojiItemHolder holder, int position) {
        holder.etv.setText(Util.getEmijoByUnicode(start+position));
    }

    @Override
    public int getItemCount() {
        return end-start+1;
    }

    public static class EmojiItemHolder extends RecyclerView.ViewHolder
    {
        private TextView etv;

        public EmojiItemHolder(View itemView)
        {
            super(itemView);
            etv = (TextView) itemView.findViewById(R.id.cv_emoji_text);
        }
    }
}
