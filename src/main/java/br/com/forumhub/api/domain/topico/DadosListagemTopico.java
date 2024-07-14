package br.com.forumhub.api.domain.topico;

import br.com.forumhub.api.domain.autor.DadosDetalhamentoAutor;
import br.com.forumhub.api.domain.curso.Curso;
import br.com.forumhub.api.domain.resposta.DadosDetalhamentoResposta;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        Boolean duvidaResolvida,
        DadosDetalhamentoAutor autor,
        Curso curso,
        List<DadosDetalhamentoResposta> respostas
) {
}
