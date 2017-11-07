package lab;

public class HttpRedirectionHandler implements HttpHandler {
    @Override
    public void handleCode() {
        System.out.println("REDIRECT");
    }
}
