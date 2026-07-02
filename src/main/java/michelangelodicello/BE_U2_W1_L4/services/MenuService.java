package michelangelodicello.BE_U2_W1_L4.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import michelangelodicello.BE_U2_W1_L4.entities.Bevanda;
import michelangelodicello.BE_U2_W1_L4.entities.Pizza;
import michelangelodicello.BE_U2_W1_L4.entities.Topping;
import michelangelodicello.BE_U2_W1_L4.exception.NotFoundException;
import michelangelodicello.BE_U2_W1_L4.repositories.MenuItemRepository;
import michelangelodicello.BE_U2_W1_L4.repositories.PizzaRepository;
import michelangelodicello.BE_U2_W1_L4.repositories.ToppingRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuService {

    private final MenuItemRepository menuItemRepository;
    private final PizzaRepository pizzaRepository;
    private final ToppingRepository toppingRepository;

    public void saveNewPizza(Pizza newPizza) {

        if (this.pizzaRepository.existsByNome(newPizza.getNome())) {
            throw new RuntimeException("La pizza '" + newPizza.getNome() + "' è già presente nel menu!");
        }

        if (newPizza.getPrezzo() <= 0) {
            throw new RuntimeException("Il prezzo della pizza deve essere maggiore di 0€");
        }

        if (newPizza.getNome() == null || newPizza.getNome().trim().isEmpty()) {
            throw new RuntimeException("Il nome della pizza non può essere vuoto");
        }

        if (newPizza.getInfoNutrizionali() == null) {
            newPizza.setInfoNutrizionali("Informazioni non disponibili");
        }

        this.pizzaRepository.save(newPizza);

        log.info("La pizza " + newPizza.getNome() + " è stata inserita nel menu correttamente a €" + newPizza.getPrezzo());
    }

    public void saveNewTopping(Topping newTopping) {

        if (this.toppingRepository.existsByNome(newTopping.getNome())) {
            throw new RuntimeException("Il topping '" + newTopping.getNome() + "' è già presente nel database!");
        }

        if (newTopping.getNome() == null || newTopping.getNome().trim().isEmpty()) {
            throw new RuntimeException("Il nome del topping non può essere vuoto");
        }

        if (newTopping.getPrezzo() < 0) {
            throw new RuntimeException("Il prezzo del topping non può essere negativo (al massimo 0€ se gratuito)");
        }

        this.toppingRepository.save(newTopping);

        log.info("Il topping " + newTopping.getNome() + " è stato salvato correttamente con un prezzo di €" + newTopping.getPrezzo());
    }

    public void saveNewBevanda(Bevanda newBevanda) {

        if (this.menuItemRepository.existsByNome(newBevanda.getNome())) {
            throw new RuntimeException("L'elemento '" + newBevanda.getNome() + "' è già presente nel menu!");
        }

        if (newBevanda.getNome() == null || newBevanda.getNome().trim().isEmpty()) {
            throw new RuntimeException("Il nome della bevanda non può essere vuoto");
        }

        if (newBevanda.getPrezzo() <= 0) {
            throw new RuntimeException("Il prezzo della bevanda deve essere maggiore di 0€");
        }

        if (newBevanda.getInfoNutrizionali() == null || newBevanda.getInfoNutrizionali().trim().isEmpty()) {
            newBevanda.setInfoNutrizionali("Informazioni nutrizionali non specificate");
        }

        this.menuItemRepository.save(newBevanda);

        log.info("La bevanda " + newBevanda.getNome() + " è stata salvata correttamente nel menu a €" + newBevanda.getPrezzo());
    }

    public Pizza findPizzaById(long pizzaId) {
        return this.pizzaRepository.findById(pizzaId).orElseThrow(() -> new NotFoundException("Pizza con ID: " + pizzaId + "non trovato"));
    }

    public Topping findToppingById(Long toppingId) {
        return this.toppingRepository.findById(toppingId).orElseThrow(() -> new NotFoundException("Pizza con ID: " + toppingId + "non trovato"));
    }
}