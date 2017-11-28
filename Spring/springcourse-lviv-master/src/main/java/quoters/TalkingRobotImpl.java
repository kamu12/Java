package quoters;


import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;


    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
