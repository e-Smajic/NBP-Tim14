package ba.unsa.etf.confix_be.payloads.request.insert;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;

@Getter
@Setter
public class LogInsertRequestDto {
    @Length(min = 3)
    private String actionName;

    @Length(min = 3)
    private String tableName;

    private LocalDateTime dateTime;

    @Nullable
    private String dbUser;
}
