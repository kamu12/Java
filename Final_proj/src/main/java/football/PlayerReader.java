package football;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK;

@Service
public class PlayerReader implements Reader {

    @Autowired
    private JavaSparkContext sc;

    @Override
    public DataFrame read() {
        SQLContext sqlContext = new SQLContext(sc);

        JavaRDD<String> rdd = sc.textFile("data/teams.properties");
        rdd.persist(MEMORY_AND_DISK());

        JavaRDD<Team> teamRdd = rdd.filter(line -> !line.isEmpty())
                .map(String::toLowerCase)
                .map(line -> {
                    String[] data = line.split("=");
                    Team team = Team.builder()
                            .name(data[0])
                            .players(data[1].split(","))
                            .build();
                    return team;
                });

        return sqlContext.createDataFrame(teamRdd, Team.class);

    }
}
