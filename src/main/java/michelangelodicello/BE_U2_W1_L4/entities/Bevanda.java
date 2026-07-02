package michelangelodicello.BE_U2_W1_L4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bevande")
@NoArgsConstructor
public class Bevanda extends MenuItem {

    public Bevanda(String nome, double prezzo, String infoNutrizionali) {
        super(nome, prezzo, infoNutrizionali);
    }
}