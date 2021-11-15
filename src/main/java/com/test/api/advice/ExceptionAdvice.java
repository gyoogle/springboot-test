package com.test.api.advice;

import com.test.api.advice.exception.CEmailSigninFailedException;
import com.test.api.advice.exception.CUserNotFoundException;
import com.test.api.common.ResponseMessage;
import com.test.api.common.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

    private ResponseMessage responseMessage;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<ResponseMessage> defaultException(HttpServletRequest request, Exception e) {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        responseMessage = new ResponseMessage();
        responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
        responseMessage.setMessage("Default Exception");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<ResponseMessage> userNotFound(HttpServletRequest request, CUserNotFoundException e) {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        responseMessage = new ResponseMessage();
        responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
        responseMessage.setMessage("유저를 찾을 수 없습니다.");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CEmailSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<ResponseMessage> emailSigninFailed(HttpServletRequest request, CEmailSigninFailedException e) {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        responseMessage = new ResponseMessage();
        responseMessage.setStatus(StatusEnum.INTERNAL_SERER_ERROR);
        responseMessage.setMessage("해당 계정이 존재하지 않거나, 이메일 또는 비밀번호가 정확하지 않습니다.");

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}