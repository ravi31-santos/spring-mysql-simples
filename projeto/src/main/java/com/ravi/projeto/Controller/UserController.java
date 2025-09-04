package com.ravi.projeto.Controller;

import com.ravi.projeto.Model.User;
import com.ravi.projeto.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<User> listar(){
        return repository.findAll();
    }

    @PostMapping
    public User criar(@RequestBody User user){
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User atualizar(@PathVariable Long id, @RequestBody User user){
        User existente = repository.findById(id).orElseThrow();
        existente.setNome(user.getNome());
        existente.setIdade(user.getIdade());
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    public User deletar(@PathVariable Long id) {
      repository.deleteById(id);
        return null;
    }

}
