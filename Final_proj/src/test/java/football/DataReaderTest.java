package football;

import org.apache.spark.api.java.JavaSparkContext;
import org.codehaus.janino.Java;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static football.Const.DEV;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@ActiveProfiles(DEV)
public class DataReaderTest {
    @Autowired
    private DataReader dataFrameVaildator;

    @Autowired
    private JavaSparkContext sc;

    @Test
    public void validate() throws Exception {
    }

}