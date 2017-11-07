package mySpring;

import factory.InjectRandomInt;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

public class RandIntConfigurator implements ObjectConfigurator {
    Random random = new Random();
    @Override
    @SneakyThrows
    public <T> void config(T o, Class<T> type) {

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {

            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomIntValue = random.nextInt(max - min) + min;
                field.setAccessible(true);
                field.set(o,randomIntValue);

            }
        }
    }
}