package ayalma.ir.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ayalma.ir.chatview.ChatView;
import ayalma.ir.chatview.Message;

public class MainActivity extends AppCompatActivity {

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


        chatView.addMessage(new Message("hello","14:11",Message.OUT_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.IN_MESSAGE));
        chatView.addMessage(new Message("hello","14:11",Message.OUT_MESSAGE));
    }
}
