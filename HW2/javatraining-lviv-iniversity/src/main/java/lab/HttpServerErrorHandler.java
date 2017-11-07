package lab;

public class HttpServerErrorHandler implements HttpHandler {
    @Override
    public void handleCode() {
        System.out.println("SERVER ERROR");
    }
}
