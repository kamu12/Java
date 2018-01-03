package football;

import org.apache.spark.sql.DataFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static football.Const.DEV;

public class Main {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", DEV);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DataReader reader = context.getBean(DataReader.class);
        DataProcessor dataProcessor = context.getBean(DataProcessor.class);

        DataFrame dataFrame = reader.read();
        DataFrame processData = dataProcessor.processData(dataFrame);

        //for test purposes
        processData.toJavaRDD().foreach(System.out::println);
    }
}
