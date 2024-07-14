package br.com.forumhub.api.domain.topico;

import br.com.forumhub.api.domain.curso.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriacaoTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        Long idAutor,
        @NotNull
        @Valid
        Curso curso) {
}
