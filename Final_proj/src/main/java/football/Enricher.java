package football;

import org.apache.spark.sql.DataFrame;

import javax.xml.crypto.Data;

public interface Enricher {
    public DataFrame enrich(DataFrame dataFrame);
}
