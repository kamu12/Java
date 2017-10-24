package never_use_switch;

public class CallMailInfo extends MailInfo {
    public CallMailInfo(int mailCode) {
        super(mailCode);
    }

    @Override
    public void sendMail()
    {
        //45 lines of code
        System.out.println("don't call us we call you. was generated and sent to " + this);
    }
}
