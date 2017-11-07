package lab;

public class HttpSuccessHandler implements HttpHandler {
    @Override
    public void handleCode() {
        System.out.println("SUCCESS");
    }
}
