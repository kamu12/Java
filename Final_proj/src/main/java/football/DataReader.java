package football;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static football.DataUtils.parseItem;
import static org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK;

@Service
public class DataReader implements Reader {

    @Autowired
    private JavaSparkContext sc;


    @Override
    public DataFrame read() {
        SQLContext sqlContext = new SQLContext(sc);

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

        return sqlContext.createDataFrame(eventRdd, FootballEvent.class);
    }
}
