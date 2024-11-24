package cesar.school.raycharge.application.authentication.common;

public class ErrorResponse {
    Integer code;
    String message;

    public ErrorResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
