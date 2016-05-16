package ayalma.ir.chatview;

/**
 * Created by alimohammadi on 5/16/16.
 *
 * @author alimohammadi.
 */
 class Util {
    public static String getEmijoByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}
