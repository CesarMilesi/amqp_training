package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageRepository {

    public ArrayList<String> Messages = new ArrayList<>(10);

    public ChatMessageRepository(ArrayList<String> messages) {
        Messages = messages;
    }

    public void addChatMessage(String message) {
        Messages.add(message);
    }

    public List<String> getLastTenMessage() {
        if (Messages.size() > 11) {
            Messages.remove(0);
        }
            return Messages.subList(Math.max(Messages.size() - 10, 0), Messages.size());
    }
}
