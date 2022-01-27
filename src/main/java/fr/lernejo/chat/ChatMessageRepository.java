package fr.lernejo.chat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatMessageRepository {

    public ArrayList<String> Messages;

    public ChatMessageRepository() {
        this.Messages = new ArrayList<String>(10);
    }

    public void addChatMessage(String message) {
        Messages.add(message);
    }

    public List<String> getLastTenMessage() {
        if (Messages.size() < 10) {
            return Messages.subList(0, Messages.size());
        }
        else {
            return Messages.subList(Math.max(Messages.size() - 10, 0), Messages.size());
        }
    }
}
