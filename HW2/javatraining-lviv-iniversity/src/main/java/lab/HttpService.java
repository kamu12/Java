package lab;

public class HttpService {
    public static void handleHttpCode(int code) {
        HttpStatus httpCode = HttpStatus.findByHttpCode(code);

        httpCode.getHandler().handleCode();
    }
}
