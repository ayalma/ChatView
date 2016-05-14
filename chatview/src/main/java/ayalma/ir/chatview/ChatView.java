package ayalma.ir.chatview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alimohammadi on 5/13/16.
 *
 * @author alimohammadi.
 */
public class ChatView extends RecyclerView {
    public ChatView(Context context) {
        super(context);
        initChatView(null, 0);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initChatView(attrs, 0);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initChatView(attrs, defStyle);
    }

    private void initChatView(AttributeSet attrs, int defStyle) {
        setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        setAdapter(new Adapter());
    }

    public void setMessages(List<Message> messages) {

        getInternalAdapter().setMessages(messages);

    }

    public void addMessage(Message message)
    {
        getInternalAdapter().addMessage(message);
    }

    private Adapter getInternalAdapter() {
        if (getAdapter() == null)
            setAdapter(new Adapter());

        return ((Adapter) getAdapter());
    }


    public static class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        List<Message> messages;

        public Adapter() {
            messages = new ArrayList<>();
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }

        public void addMessage(Message message) {
            int start = messages.size();
            messages.add(message);
            notifyItemInserted(start);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View rootView;

            if (viewType == Message.IN_MESSAGE) {
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_view_message_in, parent, false);
                return new InMessageHolder(rootView);
            } else {
                rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_view_message_out, parent, false);
                return new OutMessageHolder(rootView);
            }
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            if (messages.get(position).getMessageType() == Message.IN_MESSAGE)
                onBindInMessageHolder((InMessageHolder) holder,position);
            else onBindOutMessageHolder((OutMessageHolder) holder,position);
        }

        private void onBindOutMessageHolder(OutMessageHolder holder, int position)
        {
            holder.mtv.setText(messages.get(position).getMessage());
        }

        private void onBindInMessageHolder(InMessageHolder holder, int position) {
            holder.mtv.setText(messages.get(position).getMessage());
        }

        @Override
        public int getItemCount() {
            return messages.size();
        }

        @Override
        public int getItemViewType(int position)
        {
           return messages.get(position).getMessageType();
        }
    }

    private static class InMessageHolder extends RecyclerView.ViewHolder {

        private TextView mtv,ttv;

        public InMessageHolder(View itemView) {
            super(itemView);
            mtv = (TextView) itemView.findViewById(R.id.msg_text);
            ttv = (TextView) itemView.findViewById(R.id.msg_time);
        }
    }

    private static class OutMessageHolder extends RecyclerView.ViewHolder
    {
        private TextView mtv;
        private ImageView sendIndicator;
        private TextView ttv;
        public OutMessageHolder(View itemView)
        {
            super(itemView);
            mtv = (TextView) itemView.findViewById(R.id.msg_text);
            sendIndicator = (ImageView) itemView.findViewById(R.id.msg_sendIndicator);
            ttv = (TextView) itemView.findViewById(R.id.msg_time);
        }
    }
}
