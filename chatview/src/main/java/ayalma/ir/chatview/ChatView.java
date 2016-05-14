package ayalma.ir.chatview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alimohammadi on 5/13/16.
 *
 * @author alimohammadi.
 */
public class ChatView extends RecyclerView {
    public ChatView(Context context) {
        super(context);
        initChatView(null,0);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initChatView(attrs,0);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initChatView(attrs,defStyle);
    }

    private void initChatView(AttributeSet attrs, int defStyle) {
        setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        setAdapter(new Adapter());
    }

    public static class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final int ITEM_TYPE_ODD = 0;
        private final int ITEM_TYPE_EVEN = 1;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View rootView;

            if (viewType == ITEM_TYPE_EVEN)
            {
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_view_row_even,parent,false);
                return  new ItemHolderEven(rootView);
            }
           else
            {
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_view_row_odd,parent,false);
                return new ItemHolderOdd(rootView);
            }
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 25;
        }

        @Override
        public int getItemViewType(int position)
        {
            if (position % 2 == 0)
                return ITEM_TYPE_EVEN;
            return ITEM_TYPE_ODD;
        }
    }

    private static class ItemHolderOdd extends RecyclerView.ViewHolder {

        public ItemHolderOdd(View itemView) {
            super(itemView);
        }
    }

    private static class ItemHolderEven extends RecyclerView.ViewHolder {

        public ItemHolderEven(View itemView) {
            super(itemView);
        }
    }
}
