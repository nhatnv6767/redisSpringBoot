package redis.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User  implements Serializable {
    @Id
    private String username;
    private String displayName;
}
