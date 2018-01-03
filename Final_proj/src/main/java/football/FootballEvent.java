package football;

import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.time.LocalTime;

@Data
@Builder
public class FootballEvent {
    private int code;
    private String from;
    private String to;
    private String eventTime;
    private String startTime;
    private String stadium;
}
