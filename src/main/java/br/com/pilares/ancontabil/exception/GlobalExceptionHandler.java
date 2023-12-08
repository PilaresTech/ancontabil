package br.com.pilares.ancontabil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<Object> handleMinhaExcecaoPersonalizada(BaseException ex) {
    	log.info("validacao exception {}", ex.getMensagens().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMensagens());
    }

}
