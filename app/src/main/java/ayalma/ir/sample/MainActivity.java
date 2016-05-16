package ayalma.ir.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import ayalma.ir.chatview.ChatView;
import ayalma.ir.chatview.EmojiView;
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

        int code = 0x1F60A;
        code++;
        StringBuilder stringBuilder = new StringBuilder().append(":-)" + getEmijoByUnicode(0x1F60A)).append(getEmijoByUnicode(code));
        Log.d(TAG,stringBuilder.toString());
        chatView.addMessage(new Message(stringBuilder.toString(),"14:11",Message.OUT_MESSAGE));
        chatView.addMessage(new Message("سلام حالت خوبه","14:11",Message.OUT_MESSAGE));

        chatView.addMessage(new Message("hello","14:11",Message.OUT_MESSAGE));

        chatView.setMessageListener(new ChatView.MessageListener() {
            @Override
            public void onMessageSelected(boolean selected, int position, Message message) {
                Log.d(TAG,createMessage(selected,position,message));
             //   EmojiDialog emojiDialog = new EmojiDialog();
                //emojiDialog.show(getSupportFragmentManager(),"");

            }

            private String createMessage(boolean selected, int position, Message message) {
                StringBuilder sb = new StringBuilder();
                sb.append("message with position :").append(position).append(" clicked and its ").append((selected)?" selected":"not selected").append( "and value of message is:").append(message.getMessage());

                return sb.toString();
            }
        });

        btnCreatePopup = (Button) findViewById(R.id.show);
        btnCreatePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPopup();
            }
        });

        checkKeyborad(getWindow().getDecorView().getRootView());


        editText = (EditText) findViewById(R.id.msg);
    }
    EditText editText;

    Button btnClosePopup;
    Button btnCreatePopup;

    private PopupWindow popupWindow;

    private void callPopup() {


        EmojiView emojiView = new EmojiView(this);
        emojiView.show();


    }


    public String getEmijoByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    void checkKeyborad(final View rootView)
    {
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = rootView.getRootView().getHeight()- rootView.getHeight();
                changeEmoHeight(heightDiff);
            }
        });
    }

    private void changeEmoHeight(int heightDiff) {
        if (popupWindow !=null)
            popupWindow.setHeight(heightDiff);
    }
}
