package quoters;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
@Component
public class TerminatorQuoter implements Quoter {
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void killAll() {
        System.out.println("You are terminated....");
    }

    @Value("${my.list.of.quotes}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }
}
