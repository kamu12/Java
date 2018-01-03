package football;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.sources.In;

import static football.Const.MAX_MATCH_DURATION;

public class TimeValidator implements Validator {
    @Override
    public DataFrame validate(DataFrame dataFrame) {
        return dataFrame.filter(String.valueOf(Integer.parseInt("eventTime".split(":")[0]) <= MAX_MATCH_DURATION))
                        .filter(String.valueOf(Integer.parseInt("startTime".split(":")[0]) <= MAX_MATCH_DURATION));
    }
}
