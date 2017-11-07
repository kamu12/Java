package mySpring;

import lombok.SneakyThrows;
import java.util.Random;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    RandIntConfigurator configurator = new RandIntConfigurator();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }
        T o = type.newInstance();

        configurator.config(o, type);

        return o;
    }
}
