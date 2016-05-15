package ayalma.ir.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ayalma.ir.chatview.ChatView;
import ayalma.ir.chatview.Message;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChatView chatView = (ChatView) findViewById(R.id.chat_view);

        assert chatView != null;
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.OUT_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));


        chatView.addMessage(new Message("سلام","14:11",Message.OUT_MESSAGE));
        chatView.addMessage(new Message("سلام حالت خوبه","14:11",Message.OUT_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.OUT_MESSAGE));

        chatView.setMessageListener(new ChatView.MessageListener() {
            @Override
            public void onMessageSelected(boolean selected, int position, Message message) {
                Log.d(TAG,createMessage(selected,position,message));
            }

            private String createMessage(boolean selected, int position, Message message) {
                StringBuilder sb = new StringBuilder();
                sb.append("message with position :").append(position).append(" clicked and its ").append((selected)?" selected":"not selected").append( "and value of message is:").append(message.getMessage());

                return sb.toString();
            }
        });
    }
}
