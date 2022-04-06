package br.com.zup.edu.colecionaveis.api.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String descricao;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Figurinha> figurinhas = new ArrayList<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Album() {
    }

    public Album(String titulo, String descricao, Integer numeroPaginas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
    }

    public void adicionaFigurinha(Figurinha figurinha) {
        figurinha.setAlbum(this);
        this.figurinhas.add(figurinha);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public List<Figurinha> getFigurinhas() {
        return Collections.unmodifiableList(figurinhas);
    }
}
