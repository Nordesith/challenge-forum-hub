package br.com.forumhub.api.domain.topico;


import br.com.forumhub.api.domain.autor.Autor;
import br.com.forumhub.api.domain.curso.Curso;
import br.com.forumhub.api.domain.resposta.Resposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean duvidaResolvida;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas;

    public Topico(DadosCriacaoTopico dados, Autor autor) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.duvidaResolvida = false;
        this.autor = autor;
        this.curso = dados.curso();
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if(dados.duvidaResolvida() != null){
            this.duvidaResolvida = dados.duvidaResolvida();
        }
    }
}
