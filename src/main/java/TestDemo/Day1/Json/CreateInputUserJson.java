package TestDemo.Day1.Json;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateInputUserJson {

    @JsonProperty("UserName")
    private String username;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Phone_No")
    private String phone;
}