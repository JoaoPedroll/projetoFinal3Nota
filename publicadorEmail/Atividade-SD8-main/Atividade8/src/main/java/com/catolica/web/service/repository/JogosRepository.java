package com.catolica.web.service.repository;
import com.catolica.web.service.model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosRepository extends JpaRepository<Jogos, Integer> {
    @Query(value = "SELECT * FROM cleintes WHERE id = $1)", nativeQuery = true)
    void saveJogo(Jogos jogos);
}
