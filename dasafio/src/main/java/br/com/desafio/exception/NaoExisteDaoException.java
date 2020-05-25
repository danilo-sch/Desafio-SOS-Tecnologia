package br.com.desafio.exception;

public class NaoExisteDaoException extends RuntimeException {

    public NaoExisteDaoException(String message) {
        super(message);
    }
}
