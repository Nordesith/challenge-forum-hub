package br.com.forumhub.api.domain.resposta;

import br.com.forumhub.api.domain.autor.DadosDetalhamentoAutor;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        String mensagem,
        LocalDateTime data,
        DadosDetalhamentoAutor Autor
) {
}
