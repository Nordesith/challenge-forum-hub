package br.com.forumhub.api.controller;

import br.com.forumhub.api.domain.autor.Autor;
import br.com.forumhub.api.domain.autor.AutorRepository;
import br.com.forumhub.api.domain.autor.DadosCadastroAutor;
import br.com.forumhub.api.domain.autor.DadosDetalhamentoAutor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("autores")
public class AutorController {
    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroAutor(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder){
        var autor = new Autor(dados);
        repository.save(autor);

        var uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAutor(autor));
    }
}
