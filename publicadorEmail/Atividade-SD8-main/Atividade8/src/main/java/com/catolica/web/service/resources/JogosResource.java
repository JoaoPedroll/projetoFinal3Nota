package com.catolica.web.service.resources;
import com.catolica.web.service.model.Jogos;
import com.catolica.web.service.repository.JogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class JogosResource {

    private JogosRepository jogosRepository;

    @Autowired
    public JogosResource(JogosRepository jogosRepository) {
        this.jogosRepository = jogosRepository;
    }

    @GetMapping("/jogos")
    public ResponseEntity<List<Jogos>> getJogos() {
        List<Jogos> todosOsJogos = this.jogosRepository.findAll();

        return new ResponseEntity<>(todosOsJogos, HttpStatus.OK);
    }


    //Create
    @PostMapping("/jogos/create")
    public void postJogo(@RequestBody Jogos jogos) {
        this.jogosRepository.save(jogos);
    }

    //read
    @GetMapping("/jogos/{id}")
    public Jogos readJogo(@PathVariable("id") int idJogo) {
         return this.jogosRepository.findById(idJogo).get(); }


    //update
    @PutMapping("/jogos/{id}")
    public Jogos updateJogo(@PathVariable("id") int idJogo,
                               @RequestBody Jogos jogos) {
        jogos.setId(idJogo);

        this.jogosRepository.save(jogos);

        return jogos;
    }

    //delete
    @DeleteMapping("/jogos/{id}")
    public void deleteJogo(@PathVariable("id") int idJogo) {
        this.jogosRepository.deleteById(idJogo);
    }


}
