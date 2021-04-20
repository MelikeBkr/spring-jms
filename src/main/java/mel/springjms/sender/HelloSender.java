package mel.springjms.sender;

import lombok.RequiredArgsConstructor;
import mel.springjms.config.JmsConfig;
import mel.springjms.model.HelloWorldMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender
{
    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage()
    {
        System.out.println("Sender is sending a message");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World")
                .build();
        jmsTemplate.convertAndSend(JmsConfig.QUEUE_NAME,message);
        System.out.println("Message is sent");
    }
}
