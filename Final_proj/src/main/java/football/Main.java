package football;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static football.Const.DEV;

public class Main {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", DEV);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DataReader reader = context.getBean(DataReader.class);
        reader.read();
    }
}
