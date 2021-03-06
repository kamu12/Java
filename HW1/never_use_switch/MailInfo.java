package never_use_switch;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class MailInfo {
    private Client client;
    private int mailCode;


    public MailInfo(int mailCode) {
        this.mailCode = mailCode;
    }

    public abstract void sendMail();
}
