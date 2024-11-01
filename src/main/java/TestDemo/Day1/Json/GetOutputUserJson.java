package TestDemo.Day1.Json;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetOutputUserJson {

    @JsonProperty("UserId")
    private UUID userId;

    @JsonProperty("UserName")
    private String username;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Phone_No")
    private String phone;
}
