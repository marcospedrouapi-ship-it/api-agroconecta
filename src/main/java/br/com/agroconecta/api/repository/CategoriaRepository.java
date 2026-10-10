package br.com.agroconecta.api.repository;
import br.com.agroconecta.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
