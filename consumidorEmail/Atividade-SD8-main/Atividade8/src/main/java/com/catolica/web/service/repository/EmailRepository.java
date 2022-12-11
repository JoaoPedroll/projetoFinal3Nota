package com.catolica.web.service.repository;
import com.catolica.web.service.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
    @Query(value = "SELECT * FROM cleintes WHERE id = $1)", nativeQuery = true)
    void saveEmail(Email email);
}
