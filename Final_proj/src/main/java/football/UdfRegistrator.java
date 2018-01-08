package football;

import lombok.SneakyThrows;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class UdfRegistrator implements ApplicationListener<ContextRefreshedEvent> {
    public static final String CALL = "call";

    @Autowired
    private ApplicationContext context;

    @Autowired
    private SQLContext sqlContext;

    private Map<String, DataType> typesMap = new HashMap<>();

    @PostConstruct
    private void init(){
        typesMap.put("String", DataTypes.StringType);
        typesMap.put("Integer", DataTypes.IntegerType);
        typesMap.put("Boolean", DataTypes.BooleanType);
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Collection<Object> udfObjects = context.getBeansWithAnnotation(RegisterUdf.class).values();
        for (Object udfObject : udfObjects) {
            sqlContext.udf().register(udfObject.getClass().getName(),
                    (UDF1<?, ?>) udfObject,
                    typesMap.get(udfObject.getClass().getMethod(CALL, String.class).getReturnType().getSimpleName()));
        }
    }
}
