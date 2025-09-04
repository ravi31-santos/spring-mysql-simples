package com.ravi.projeto.Controller;

import com.ravi.projeto.Model.Admin;
import com.ravi.projeto.Repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    private AdminRepository repository;

    public AdminController(AdminRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Admin> listar(){
        return repository.findAll();
    }
    @PostMapping
    public Admin criar(@RequestBody Admin admin){
        return repository.save(admin);
    }
    @PutMapping("/{id}")
    public Admin atualizar(@PathVariable Long id, @RequestBody Admin admin){
        Admin existente = repository.findById(id).orElseThrow();
        existente.setNomeAdm(admin.getNomeAdm());
        existente.setCargoAdm(admin.getCargoAdm());
        return repository.save(existente);
    }
    @DeleteMapping("/{id}")
    public Admin deletar(@PathVariable Long id){
        repository.deleteById(id);
        return null;
    }

}
