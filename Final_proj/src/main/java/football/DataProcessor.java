package football;

import com.oracle.webservices.internal.api.databinding.DatabindingModeFeature;
import lombok.Data;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.apache.spark.sql.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DataProcessor {

    @Autowired(required = false)
    private List<Validator> dataValidators;

    @Autowired(required = false)
    private List<Enricher> dataEnrichers;

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
