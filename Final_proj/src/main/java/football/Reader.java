package football;

import org.apache.spark.sql.DataFrame;

public interface Reader {
    DataFrame read();
}
