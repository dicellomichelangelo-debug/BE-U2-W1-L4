package michelangelodicello.BE_U2_W1_L4.runners;

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

    }
}
