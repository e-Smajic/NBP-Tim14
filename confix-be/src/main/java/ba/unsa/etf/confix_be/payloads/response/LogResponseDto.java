package ba.unsa.etf.confix_be.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogResponseDto {
    private Long id;
    private String actionName;
    private String tableName;
    private LocalDateTime dateTime;
    private String dbUser;
}
