package lab;

import lombok.Getter;

@Getter
public enum HttpStatus {
    INFO(100, 199, "інформація", new HttpInfoHandler()),
    SUCCESS(200, 299, "успіх", new HttpSuccessHandler()),
    REDIRECTION(300, 399, "перенапрямлення", new HttpRedirectionHandler()),
    CLIENT_ERROR(400, 499, "помилка клієнта", new HttpClientErrorHandler()),
    SERVER_ERROR(500, 599, "помилка сервера", new HttpServerErrorHandler());

    private int min;
    private int max;
    private String uaDescr;
    private HttpHandler handler;

    HttpStatus(int min, int max, String descr, HttpHandler handler) {
        this.min = min;
        this.max = max;
        this.uaDescr = descr;
        this.handler = handler;
    }

    public static HttpStatus findByHttpCode(int code) {
        for (HttpStatus value: values()) {
            if (code >= value.min && code <= value.max){
                return value;
            }
        }
        
        throw new RuntimeException("unknown error conde: " + code);
    }

    @Override
    public String toString(){
        return this.uaDescr.toUpperCase();
    }
}
