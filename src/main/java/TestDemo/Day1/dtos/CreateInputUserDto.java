package TestDemo.Day1.dtos;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateInputUserDto {

    private String  username;
    private String email;
    private String phone;
}
