package football;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.api.java.UDF1;

import java.io.Serializable;

import static football.Const.MAX_MATCH_DURATION;
import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;

@RegisterUdf
public class TimeValidator implements Validator, UDF1<String, Boolean>, Serializable {

    private static final String EVENTTIME = "eventTime";
    private static final String STARTTIME = "startTime";

    @Override
    public Boolean call(String time) throws Exception{
        String minute = time.split(":")[0];

        return Integer.parseInt(minute) < MAX_MATCH_DURATION;
    }


    @Override
    public DataFrame validate(DataFrame dataFrame) {
        System.out.println(TimeValidator.class.getName());
        System.out.println(col(EVENTTIME));
        return dataFrame.filter(callUDF(TimeValidator.class.getName(), (col(EVENTTIME))))
                        .filter(callUDF(TimeValidator.class.getName(), (col(STARTTIME))));
    }
}
