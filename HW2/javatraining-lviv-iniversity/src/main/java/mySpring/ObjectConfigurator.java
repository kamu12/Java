package mySpring;

public interface ObjectConfigurator {
    <T> void config(T o, Class<T> type);
}
