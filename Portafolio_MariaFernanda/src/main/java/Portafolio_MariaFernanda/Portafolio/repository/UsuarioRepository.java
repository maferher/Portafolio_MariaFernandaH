package Portafolio_MariaFernanda.Portafolio.repository;

import Portafolio_MariaFernanda.Portafolio.domain.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    public Optional<Usuario> findByUsernameAndActivoTrue(String username);
    
}
