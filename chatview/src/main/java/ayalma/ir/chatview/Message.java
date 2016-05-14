package ayalma.ir.chatview;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by alimohammadi on 5/14/16.
 *
 * @author alimohammadi.
 */
public class Message {

    public final static int IN_MESSAGE = 0;
    public final static int OUT_MESSAGE = 1;

    @IntDef(value = {IN_MESSAGE, OUT_MESSAGE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    private String message;
    private boolean send;
    private boolean delivered;
    private String date;
    private int messageType;

    public Message(String message, String date, @MessageType int messageType) {
        this.message = message;
        this.date = date;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(@MessageType int messageType)
    {
        this.messageType = messageType;
    }
}
