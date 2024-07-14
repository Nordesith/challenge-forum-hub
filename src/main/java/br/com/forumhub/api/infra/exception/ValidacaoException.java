package br.com.forumhub.api.infra.exception;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
