package br.com.forumhub.api.domain.topico;

import br.com.forumhub.api.domain.autor.Autor;
import br.com.forumhub.api.domain.autor.AutorRepository;
import br.com.forumhub.api.domain.autor.DadosDetalhamentoAutor;
import br.com.forumhub.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private AutorRepository autorRepository;


    public DadosDetalhamentoTopico criarTopico(DadosCriacaoTopico dados) {

        Autor autor = autorRepository.getReferenceById(dados.idAutor());
        var topico = new Topico(dados, autor);
        repository.save(topico);

        System.out.println(dados);
        System.out.println(autor);

        return null;
    }

    public DadosDetalhamentoTopico atualizarTopico(Long id, DadosAtualizacaoTopico dados) {
        findTopicoById(id);
        var topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dados);

        return new DadosDetalhamentoTopico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getDuvidaResolvida(), new DadosDetalhamentoAutor(topico.getAutor()), topico.getCurso());
    }



    public Topico findTopicoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Tópico não encontrado"));
    }

    public DadosDetalhamentoTopico detalharTopico(Long id) {
        findTopicoById(id);
        var topico = repository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getDuvidaResolvida(), new DadosDetalhamentoAutor(topico.getAutor()), topico.getCurso());

    }

    public Long deletarTopico(Long id) {
        findTopicoById(id);
        repository.deleteById(id);
        return id;
    }
}
