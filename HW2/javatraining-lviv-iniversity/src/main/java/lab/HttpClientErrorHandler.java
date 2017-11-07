package lab;

public class HttpClientErrorHandler implements HttpHandler {
    @Override
    public void handleCode() {
        System.out.println("CLIENT ERROR");
    }
}
