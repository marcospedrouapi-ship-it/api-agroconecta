package br.com.agroconecta.api.controller;
import br.com.agroconecta.api.model.Categoria;
import br.com.agroconecta.api.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;
    
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
    
    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
