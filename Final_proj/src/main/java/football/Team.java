package football;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@Builder
public class Team {
    private String name;
    private String[] players;
}
