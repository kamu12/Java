package football;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static football.DataUtils.parseItem;
import static org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK;

@Service
public class DataReader{

    @Autowired
    private JavaSparkContext sc;


    public void read() {
        SQLContext sqlContext = new SQLContext(sc);

//        DataFrame dataFrame = sqlContext.read().format("com.databricks.spark.csv")
//                .option("delimiter", ";")
//                .option("header", "false")
//                .load("data/rawData.txt");
//
//        Row first = dataFrame.first();
//        int count = (int) dataFrame.count();
//        dataFrame.unionAll(first.);
//        dataFrame.printSchema();

        JavaRDD<String> rdd = sc.textFile("data/rawData.txt");
        rdd.persist(MEMORY_AND_DISK());

        JavaRDD<FootballEvent> eventRdd = rdd.filter(line -> !line.isEmpty())
                .map(String::toLowerCase)
                .map(line -> {
            String[] data = line.split(";");
            FootballEvent event = FootballEvent.builder().code(Integer.parseInt(parseItem(data[0])))
                    .from(parseItem(data[1]))
                    .to(parseItem(data[2]))
                    .eventTime(parseItem(data[3]))
                    .stadium(parseItem(data[4]))
                    .startTime(parseItem(data[5]))
                    .build();
            return event;
        });

        eventRdd.foreach(row -> System.out.println(row));
//        System.out.println(eventRdd.count());
//        System.out.println(eventRdd.toString());
    }
}
