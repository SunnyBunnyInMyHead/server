package ua.com.kbl.server.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.kbl.server.dao.entity.User;
import ua.com.kbl.server.service.UserService;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(final String name, final int age) {
        return this.userService.createUser(name, age);
    }
}
