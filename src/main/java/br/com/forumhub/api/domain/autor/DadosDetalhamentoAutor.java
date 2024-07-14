package br.com.forumhub.api.domain.autor;

public record DadosDetalhamentoAutor(Long id, String nome) {

    public DadosDetalhamentoAutor(Autor autor) {
        this(autor.getId(), autor.getNome());
    }
}
