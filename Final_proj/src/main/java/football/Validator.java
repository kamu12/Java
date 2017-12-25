package football;

import org.apache.spark.sql.DataFrame;

public interface Validator {

    public DataFrame validate(DataFrame dataFrame);
}
