package mel.springjms.listener;

import mel.springjms.config.JmsConfig;
import mel.springjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class HelloMessageListener
{
    @JmsListener(destination = JmsConfig.QUEUE_NAME)
    public void listener(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message)
    {
        System.out.println("Listener received the message");
        System.out.println(helloWorldMessage);
    }
}
