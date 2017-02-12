package listener;

import java.util.EventListener;

public interface TextListener extends EventListener {
    void perform(String text);
}
