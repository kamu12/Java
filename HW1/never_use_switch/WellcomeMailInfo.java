package never_use_switch;

public class WellcomeMailInfo extends MailInfo{
    public WellcomeMailInfo(int mailCode) {
        super(mailCode);
    }

    @Override
    public void sendMail()
    {
        //40 lines of code
        System.out.println("welcome mail was generated and sent to " + this);
    }
}
