package in.codingstreams.etuserauthservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessages {
    USER_ALREADY_EXISTS("E409" ,"User Already Exists!"),
    USER_NOT_FOUND("E404" ,"User not found!"),
    PASSWORD_NOT_MATCHED("E401" ,"password not matched!"),
    INVALID_ACCESS_TOKEN("T401" ,"Invalid access Token!");

    String errorCode;
    String errorMessage;
}
