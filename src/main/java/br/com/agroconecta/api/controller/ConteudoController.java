package br.com.agroconecta.api.controller;
import br.com.agroconecta.api.model.Conteudo;
import br.com.agroconecta.api.repository.ConteudoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/conteudos")
public class ConteudoController {
    private final ConteudoRepository conteudoRepository;
    
    public ConteudoController(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }
    
    @GetMapping
    public List<Conteudo> listar() {
        return conteudoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Conteudo buscarPorId(@PathVariable Long id) {
        return conteudoRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Conteudo criar(@RequestBody Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }
    
    @PutMapping("/{id}")
    public Conteudo atualizar(@PathVariable Long id, @RequestBody Conteudo conteudoAtualizado) {
        return conteudoRepository.findById(id).map(conteudo -> {
            conteudo.setTitulo(conteudoAtualizado.getTitulo());
            conteudo.setDescricao(conteudoAtualizado.getDescricao());
            conteudo.setCategoria(conteudoAtualizado.getCategoria());
            return conteudoRepository.save(conteudo);
        }).orElse(null);
    }
    
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        conteudoRepository.deleteById(id);
    }
}
