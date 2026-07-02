package michelangelodicello.BE_U2_W1_L4.repositories;

import michelangelodicello.BE_U2_W1_L4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    boolean existsByNome(String nome);

}