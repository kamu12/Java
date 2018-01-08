package football;

import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static org.apache.spark.sql.functions.col;

@Service
public class PlayerValidator implements Validator, Serializable {

    public static final String FROM = "from";
    public static final String PLAYERS = "players";
    public static final String TO = "to";

    @Autowired
    private PlayerReader playerReader;

    @Override
    public DataFrame validate(DataFrame dataFrame) {
        DataFrame players = playerReader.read();
//        dataFrame.withColumn(FROM, players.col(PLAYERS).contains())
        return dataFrame.filter(players.col(PLAYERS).contains(FROM))
                .filter(players.col(PLAYERS).contains(TO));
    }
}
