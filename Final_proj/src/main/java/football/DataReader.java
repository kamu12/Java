package football;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataReader{

    @Autowired
    private JavaSparkContext sc;


    public void read() {
        SQLContext sqlContext = new SQLContext(sc);

        DataFrame dataFrame = sqlContext.read().format("com.databricks.spark.csv")
                .option("delimiter", ";")
                .option("header", "false")
                .load("data/rawData.txt");

        int i=1;
        Row[] take = dataFrame.take(1);
        dataFrame.show();
        dataFrame.printSchema();
    }
}
