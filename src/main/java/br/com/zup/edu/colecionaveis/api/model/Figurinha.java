package br.com.zup.edu.colecionaveis.api.model;

import javax.persistence.*;

@Entity
public class Figurinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer paginaNoAlbum;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    private Album album;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Figurinha() {
    }

    public Figurinha(Integer paginaNoAlbum, String descricao) {
        this.paginaNoAlbum = paginaNoAlbum;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Integer getPaginaNoAlbum() {
        return paginaNoAlbum;
    }

    public String getDescricao() {
        return descricao;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
