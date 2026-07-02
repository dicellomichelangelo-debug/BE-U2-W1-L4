package michelangelodicello.BE_U2_W1_L4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString
@Setter
@Table(name = "pizze")
public class Pizza extends MenuItem {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nome, double prezzoBase, String infoNutrizionali) {
        super(nome, prezzoBase, infoNutrizionali);
    }

    public void aggiungiTopping(Topping topping) {
        toppings.add(topping);
        this.prezzo += topping.getPrezzo();
    }

    public List<Topping> getToppings() {
        return toppings;
    }
}