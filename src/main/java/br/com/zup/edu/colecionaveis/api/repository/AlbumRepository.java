package br.com.zup.edu.colecionaveis.api.repository;

import br.com.zup.edu.colecionaveis.api.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
