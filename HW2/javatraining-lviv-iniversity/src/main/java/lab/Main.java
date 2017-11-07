package lab;

import lombok.SneakyThrows;
import java.util.Random;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Random r = new Random();
        while(true) {
            HttpService.handleHttpCode(r.nextInt(499) + 100);
            Thread.sleep(1000);
        }
    }
}
