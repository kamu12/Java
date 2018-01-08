package football;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.api.java.UDF1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RegisterUdf
public class PlayerValidator implements Validator, UDF1<String, Boolean>, Serializable {

    public static final String FROM = "from";
    public static final String PLAYERS = "players";
    public static final String TO = "to";

    @Autowired
    private static JavaSparkContext sc;

    @Autowired
    AnnotationConfigApplicationContext context;

    private List<String> players;

    @PostConstruct
    private  void init(){
        players = new ArrayList<>();
        PlayerReader playerReader = context.getBean(PlayerReader.class);
        DataFrame dataFrame = playerReader.read();
        Row[] collect = dataFrame.select(PLAYERS).collect();
    }

    @Override
    public Boolean call(String s) throws Exception {
        return players.contains(s);
    }

    @Override
    public DataFrame validate(DataFrame dataFrame) {
        //stub
        return dataFrame.filter(dataFrame.toString());
    }
}
