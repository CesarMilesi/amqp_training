package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        System.out.println("Input a message, we will send it for you (q for quit)");
        Scanner toScan = new Scanner(System.in);
        String lineToWrite = toScan.nextLine();
        RabbitTemplate rabbitTemplate = new AnnotationConfigApplicationContext(Launcher.class).getBean(RabbitTemplate.class);
        while (!lineToWrite.equals("q")) {
            rabbitTemplate.convertAndSend("chat_keyMessage", lineToWrite);
            System.out.println("Message sent. Input a message, we will send it for you (q for quit)");
            lineToWrite = toScan.nextLine();
        }
    }
}
