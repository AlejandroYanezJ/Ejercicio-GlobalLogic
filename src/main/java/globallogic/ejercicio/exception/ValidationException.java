package globallogic.ejercicio.exception;

import globallogic.ejercicio.domain.Error;
import globallogic.ejercicio.dto.ErrorDTO;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ValidationException {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException e){
        List<FieldError> errorsArray = e.getBindingResult().getFieldErrors();
        List<Error> errors= new ArrayList<>();
        for (FieldError error: errorsArray){
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            Error er = new Error();
            er.setCodigo(400);
            er.setDetail(error.getDefaultMessage());
            er.setTimestamp(timeStamp);
            errors.add(er);
        }
        ErrorDTO responseError = new ErrorDTO();
        responseError.setErrors(errors);
        return ResponseEntity.badRequest().body(responseError);
    }
}
