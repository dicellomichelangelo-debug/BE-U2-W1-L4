package michelangelodicello.BE_U2_W1_L4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menu_items")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class MenuItem {

    @Column(nullable = false)
    protected String nome;
    @Column(nullable = false)
    protected double prezzo;
    @Column(name = "info_nutrizionali")
    protected String infoNutrizionali;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public MenuItem(String nome, double prezzo, String infoNutrizionali) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.infoNutrizionali = infoNutrizionali;
    }

    @Override
    public String toString() {
        return nome + " - € " + prezzo + " [" + infoNutrizionali + "]";
    }
}