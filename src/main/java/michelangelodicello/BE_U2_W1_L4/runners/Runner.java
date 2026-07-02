package michelangelodicello.BE_U2_W1_L4.runners;

import michelangelodicello.BE_U2_W1_L4.entities.Pizza;
import michelangelodicello.BE_U2_W1_L4.entities.Topping;
import michelangelodicello.BE_U2_W1_L4.services.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final MenuService menuService;

    public Runner(MenuService menuService) {
        this.menuService = menuService;
    }


    @Override
    public void run(String... args) throws Exception {

//        Pizza margherita = new Pizza("Margherita", 5.00, "Calories: 800");
//        menuService.saveNewPizza(margherita);
//
//        Topping prosciutto = new Topping("Prosciutto", 1.5);
//        menuService.saveNewTopping(prosciutto);
//
//
//        Topping ananas = new Topping("ananas", 2.0);
//        menuService.saveNewTopping(ananas);
//
//        Bevanda cocacola = new Bevanda("Coca-Cola", 3.00, "Calories: 150");
//        menuService.saveNewBevanda(cocacola);
//
        Pizza margheritaFromDB = menuService.findPizzaById(1L);
        Topping toppingFromDB = menuService.findToppingById(2L);
        margheritaFromDB.aggiungiTopping(toppingFromDB);
        menuService.saveNewPizza(margheritaFromDB);
    }
}
