package br.com.desafio.exception;

public class IdNaoValidoServiceException extends RuntimeException {

    public IdNaoValidoServiceException(String message) {
        super(message);
    }
}