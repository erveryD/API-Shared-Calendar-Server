package domain.apiserver.core.exception;

import domain.apiserver.core.enums.Errors;
import org.springframework.http.HttpStatus;

public class BaseBadRequestException extends BaseRuntimeException {

    public BaseBadRequestException(String message) {
        super(message);
    }

    public BaseBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseBadRequestException(Errors errors) {
        super(errors, HttpStatus.BAD_REQUEST);
    }
}

