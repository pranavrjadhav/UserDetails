package TestDemo.Day1.Common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@AllArgsConstructor
public class CommonResponse<T> {

    private Integer messageId;
    private String message;
    private HttpStatusCode status;
    private T data;

}
