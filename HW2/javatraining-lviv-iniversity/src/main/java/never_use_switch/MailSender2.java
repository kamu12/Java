package never_use_switch;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender2 {

    private Map<Integer, Class<? extends MailGenerator>> map = new HashMap<>();

    public MailSender2() {
        Reflections scanner = new Reflections("never_use_switch");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                Annotation annotation = aClass.getAnnotation(MailCode.class);
                if (annotation instanceof MailCode){
                    MailCode code = (MailCode) annotation;
                    map.put(code.value(), aClass);
                }
            }
        }
    }

    @SneakyThrows
    public void sendMail(MailInfo mailInfo) {
        Class<? extends MailGenerator> mailClass = map.get(mailInfo.getMailCode());
        if (mailClass == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        MailGenerator mailGenerator = mailClass.newInstance();
        String html = mailGenerator.generateHtml(mailInfo);
        send(html, mailInfo);
    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }
}
