import org.icefaces.ace.json.JSONException;
import org.icefaces.ace.json.JSONObject;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import java.util.Locale;

@ServerEndpoint("/backdoor")
public class Websocket {

    @OnMessage
    public String onMessage(String message) throws JSONException {
        JSONObject obj = new JSONObject(message.trim());
        try {
            Double x = obj.getDouble("x");
            Double y = obj.getDouble("y");
            Double r = obj.getDouble("r");
            Boolean inArea = Result.calculate(x, y, r);
            Result result = new Result(x, y, r, inArea);
            result.save();
            return String.format(Locale.US,"{\"x\":%.2f, \"y\":%.2f, \"r\":%.2f, \"inArea\":%s}", x, y, r, inArea ? "true" : "false");
        } catch (Exception e) {
            return "error";
        }

    }

}