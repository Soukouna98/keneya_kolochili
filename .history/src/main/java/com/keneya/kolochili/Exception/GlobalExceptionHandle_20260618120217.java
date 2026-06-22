package aon.pheno.keneya.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import aon.pheno.keneya.DTO.Response.APIResponse;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandle {

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<APIResponse<Object>> handleNotFound(EntityNotFoundException erreur) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new APIResponse<>(
                                false,
                                erreur.getMessage(),
                                "null"
                )
                );
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<APIResponse<Object>> handleIlleagal(IllegalArgumentException erreur) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new APIResponse<>(
                                false,
                                erreur.getMessage(),
                                "null"
                )
                );
        }

        @ExceptionHandler(UnauthorizedException.class)
        public ResponseEntity<APIResponse<Object>> handleUnauthorized(
                UnauthorizedException erreur) {

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(
                                new APIResponse<>(
                                        false,
                                        erreur.getMessage(),
                                        null
                                )
                        );
        }

        @ExceptionHandler(ForbiddenException.class)
        public ResponseEntity<APIResponse<Object>> handleUnauthorized(
                ForbiddenException erreur) {

                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(
                                new APIResponse<>(
                                        false,
                                        erreur.getMessage(),
                                        null
                                )
                        );
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<?> handleValidation(
                MethodArgumentNotValidException ex) {

                Map<String, String> errors = new HashMap<>();

                ex.getBindingResult()
                        .getFieldErrors()
                        .forEach(error
                                -> errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        ));

        return ResponseEntity.badRequest()
                .body(
                        new APIResponse<>(
                                false,
                                "Erreur de validation",
                                errors
                        )
                );
        }

}
