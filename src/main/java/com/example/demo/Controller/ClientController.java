package com.example.demo.Controller;

import com.example.demo.Client;
import com.example.demo.ClientDTO;
import com.example.demo.ClientRepository;
import com.example.demo.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        return clientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping("/newuser")
    public ResponseEntity<String> createClient(@RequestBody ClientDTO client) {
        Client clientEntity = new Client(client.name, client.age, client.gender, client.balance);
        clientRepository.save(clientEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Client created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClientById(@PathVariable Integer id, @RequestBody ClientDTO updatedClient) {
        return clientRepository.findById(id).map(client -> {
            client.getBalance().setAmount(updatedClient.getBalance());
            clientRepository.save(client);
            return ResponseEntity.ok("Client updated successfully");
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok("Client deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }
}
