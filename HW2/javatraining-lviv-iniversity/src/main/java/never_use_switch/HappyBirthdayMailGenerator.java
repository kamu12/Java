package never_use_switch;


@MailCode(3)
public class
HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday " + mailInfo.getClient().getName();
    }
}
