package com.catolica.web.service.resources;
import com.catolica.web.service.consumer.Consumidor;
import com.catolica.web.service.model.Email;
import com.catolica.web.service.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmailResource {

    private EmailRepository emailRepository;
    private Consumidor consumidor;

    @Autowired
    public EmailResource(EmailRepository emailRepository, Consumidor consumidor) {
        this.emailRepository = emailRepository;
        this.consumidor = consumidor;
    }


    @GetMapping("/email")
    public ResponseEntity<List<Email>> getEmail() {
        List<Email> todosOsEmails = this.emailRepository.findAll();

        return new ResponseEntity<>(todosOsEmails, HttpStatus.OK);
    }



    //Create
    @PostMapping("/jogos/create")
    public void postJogo(@RequestBody Email email) {
        this.emailRepository.save(email);
    }


    //read
    @GetMapping("/jogos/{id}")
    public Email readJogo(@PathVariable("id") int idJogo) {
         return this.emailRepository.findById(idJogo).get(); }

/*
    //update
    @PutMapping("/jogos/{id}")
    public Jogos updateJogo(@PathVariable("id") int idJogo,
                               @RequestBody Jogos jogos) {
        jogos.setId(idJogo);

        this.jogosRepository.save(jogos);

        return jogos;
    }
*/ /*
    //delete
    @DeleteMapping("/jogos/{id}")
    public void deleteJogo(@PathVariable("id") int idJogo) {
        this.jogosRepository.deleteById(idJogo);
    }
*/

}
