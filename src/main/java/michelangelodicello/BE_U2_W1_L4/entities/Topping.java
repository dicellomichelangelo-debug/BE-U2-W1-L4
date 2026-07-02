package michelangelodicello.BE_U2_W1_L4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "toppings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double prezzo;

    public Topping(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

}