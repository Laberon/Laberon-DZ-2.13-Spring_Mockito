package LaberonLSDZ2.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "EmployeeAlreadyAddedException")
public class EmployeeAlreadyAddedException extends RuntimeException {
}
