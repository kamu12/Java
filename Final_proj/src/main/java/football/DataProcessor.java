package football;

import lombok.Data;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class DataProcessor {

    @Autowired(required = false)
    private ArrayList<Validator> dataValidators;

    @Autowired(required = false)
    private ArrayList<Enricher> dataEnrichers;

    public DataFrame processData(DataFrame dataFrame){
        for(Validator validator: dataValidators){
            dataFrame = validator.validate(dataFrame);
        }

        for(Enricher enricher: dataEnrichers){
            dataFrame = enricher.enrich(dataFrame);
        }

        return dataFrame;
    }
}
