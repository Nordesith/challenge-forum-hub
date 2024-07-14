package br.com.forumhub.api.domain.resposta;

import br.com.forumhub.api.domain.autor.Autor;
import br.com.forumhub.api.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime data = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;
}
