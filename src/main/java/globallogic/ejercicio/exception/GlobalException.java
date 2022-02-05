package globallogic.ejercicio.exception;

import globallogic.ejercicio.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(Exception e){
        ErrorDTO response = new ErrorDTO();
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        error.setTimestamp(timeStamp);
        error.setCodigo(500);
        error.setDetail(e.getMessage());
        errors.add(error);
        response.setError(errors);
        return new ResponseEntity<>(response,null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException e){
        List<FieldError> errorsArray = e.getBindingResult().getFieldErrors();
        List<Error> errors = new ArrayList<>();
        for (FieldError error: errorsArray){
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            Error er = new Error();
            er.setCodigo(400);
            er.setDetail(error.getDefaultMessage());
            er.setTimestamp(timeStamp);
            errors.add(er);
        }
        ErrorDTO response = new ErrorDTO();
        response.setError(errors);
        return new ResponseEntity<>(response,null,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserRegisterException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(UserRegisterException e){
        ErrorDTO response = new ErrorDTO();
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        error.setTimestamp(timeStamp);
        error.setCodigo(e.getCode());
        error.setDetail(e.getMessage());
        errors.add(error);
        response.setError(errors);
        HttpStatus status = null;

        if (e.getCode()==404){
            status=HttpStatus.NOT_FOUND;
        }
        else if (e.getCode()==409){
            status = HttpStatus.CONFLICT;
        }
        else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(response,null,status);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(HttpMediaTypeNotSupportedException e){
        ErrorDTO response = new ErrorDTO();
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        error.setTimestamp(timeStamp);
        error.setCodigo(400);
        error.setDetail(e.getMessage());
        errors.add(error);
        response.setError(errors);
        return new ResponseEntity<>(response,null,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TokenValidationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(TokenValidationException e){
        ErrorDTO response = new ErrorDTO();
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        error.setTimestamp(timeStamp);
        error.setCodigo(e.getCode());
        error.setDetail(e.getMessage());
        errors.add(error);
        response.setError(errors);
        return new ResponseEntity<>(response,null,HttpStatus.UNAUTHORIZED);
    }



}
