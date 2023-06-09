package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final ShoppingCartService shoppingCartService;

    public DataInitializer(UserService userService,
                           RoleService roleService,
                           ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.roleService = roleService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin123");
        admin.setRoles(Set.of(adminRole, userRole));
        userService.add(admin);
        shoppingCartService.registerNewShoppingCart(admin);

        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword("user123");
        user.setRoles(Set.of(userRole));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
    }
}
