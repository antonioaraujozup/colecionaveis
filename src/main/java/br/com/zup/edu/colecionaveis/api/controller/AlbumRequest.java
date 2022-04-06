package br.com.zup.edu.colecionaveis.api.controller;

import br.com.zup.edu.colecionaveis.api.model.Album;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class AlbumRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String descricao;

    @NotNull
    @Min(10)
    @Max(100)
    private Integer numeroPaginas;

    @NotEmpty
    private List<@Valid FigurinhaRequest> figurinhas;

    public AlbumRequest(String titulo, String descricao, Integer numeroPaginas, List<FigurinhaRequest> figurinhas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
        this.figurinhas = figurinhas;
    }

    public Album paraAlbum() {
        Album album = new Album(titulo, descricao, numeroPaginas);
        this.figurinhas.forEach(fr -> album.adicionaFigurinha(fr.paraFigurinha()));
        return album;
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

    public List<FigurinhaRequest> getFigurinhas() {
        return figurinhas;
    }
}
