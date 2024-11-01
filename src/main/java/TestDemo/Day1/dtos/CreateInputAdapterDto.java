package TestDemo.Day1.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateInputAdapterDto {

    private String username;
    private String email;
    private String phone;

}
