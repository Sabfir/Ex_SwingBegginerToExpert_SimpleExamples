package listener;

import event.FormEvent;

import java.util.EventListener;

public interface FormListener extends EventListener {
    void formEventOccurred(FormEvent event);
}
