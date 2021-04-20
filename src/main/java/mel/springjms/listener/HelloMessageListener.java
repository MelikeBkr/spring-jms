package mel.springjms.listener;

import lombok.RequiredArgsConstructor;
import mel.springjms.config.JmsConfig;
import mel.springjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloMessageListener
{
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.QUEUE)
    public void listener(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message)
    {
        //System.out.println("Listener received the message");
        //System.out.println(helloWorldMessage);
    }
    @JmsListener(destination = JmsConfig.SEND_RECEIVE_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                               @Headers MessageHeaders headers, Message message) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);

    }
}
