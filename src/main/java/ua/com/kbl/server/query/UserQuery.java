package ua.com.kbl.server.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.kbl.server.dao.entity.User;
import ua.com.kbl.server.service.UserService;

import java.util.List;
import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public List<User> getUsers(final int count) {
        return this.userService.getAllUsers(count);
    }

    public Optional<User> getUser(final int id) {
        return this.userService.getUser(id);
    }
}