package br.com.zup.edu.colecionaveis.api.controller;

import br.com.zup.edu.colecionaveis.api.model.Album;
import br.com.zup.edu.colecionaveis.api.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoAlbumController {

    private final AlbumRepository repository;

    public CadastrarNovoAlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/albuns")
    public ResponseEntity cadastrar(@RequestBody @Valid AlbumRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Album novoAlbum = request.paraAlbum();

        repository.save(novoAlbum);

        URI location = uriComponentsBuilder.path("/albuns/{id}")
                .buildAndExpand(novoAlbum.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
