package michelangelodicello.BE_U2_W1_L4.services;

import lombok.RequiredArgsConstructor;
import michelangelodicello.BE_U2_W1_L4.entities.MenuItem;
import michelangelodicello.BE_U2_W1_L4.entities.Pizza;
import michelangelodicello.BE_U2_W1_L4.entities.Topping;
import michelangelodicello.BE_U2_W1_L4.repositories.MenuItemRepository;
import michelangelodicello.BE_U2_W1_L4.repositories.PizzaRepository;
import michelangelodicello.BE_U2_W1_L4.repositories.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuItemRepository menuItemRepository;
    private final PizzaRepository pizzaRepository;
    private final ToppingRepository toppingRepository;

    public MenuItem salvaItem(MenuItem item) {
        return menuItemRepository.save(item);
    }

    public Topping salvaTopping(Topping topping) {
        return toppingRepository.save(topping);
    }

    public List<MenuItem> recuperaTuttoIlMenu() {
        return menuItemRepository.findAll();
    }

    public Pizza aggiungiToppingAPizza(Long pizzaId, Long toppingId) {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new RuntimeException("Pizza non trovata con ID: " + pizzaId));

        Topping topping = toppingRepository.findById(toppingId)
                .orElseThrow(() -> new RuntimeException("Topping non trovato con ID: " + toppingId));

       
        pizza.aggiungiTopping(topping);

        return pizzaRepository.save(pizza);
    }
}