package football;

import org.apache.spark.sql.DataFrame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static football.Const.DEV;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DataReader reader = context.getBean(DataReader.class);

        DataProcessor dataProcessor = context.getBean(DataProcessor.class);

        ArrayList<Validator> validators = new ArrayList<Validator>();
        validators.add(context.getBean(TimeValidator.class));
        validators.add(context.getBean(PlayerValidator.class));
        dataProcessor.setDataValidators(validators);

        ArrayList<Enricher> enrichers = new ArrayList<Enricher>();
        dataProcessor.setDataEnrichers(enrichers);

        DataFrame dataFrame = reader.read();
        dataFrame.show(false);
//        DataFrame processData = dataProcessor.processData(dataFrame);
//        processData.show(false);
    }
}
