package TestDemo.Day1.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAdapterOutputDtos {

    private UUID userId;
    private String username;
    private String email;
    private String phone;
}
