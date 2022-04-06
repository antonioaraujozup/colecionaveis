package br.com.zup.edu.colecionaveis.api.controller;

import br.com.zup.edu.colecionaveis.api.model.Figurinha;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FigurinhaRequest {

    @NotNull
    @Positive
    @Max(100)
    private Integer paginaNoAlbum;

    @NotBlank
    private String descricao;

    public FigurinhaRequest(Integer paginaNoAlbum, String descricao) {
        this.paginaNoAlbum = paginaNoAlbum;
        this.descricao = descricao;
    }

    public Figurinha paraFigurinha(){
        return new Figurinha(paginaNoAlbum,descricao);
    }

    public Integer getPaginaNoAlbum() {
        return paginaNoAlbum;
    }

    public String getDescricao() {
        return descricao;
    }
}
