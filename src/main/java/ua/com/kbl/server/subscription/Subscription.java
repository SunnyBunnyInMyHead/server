package ua.com.kbl.server.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ua.com.kbl.server.dao.entity.User;
import ua.com.kbl.server.service.UserService;

import java.time.Duration;
import java.util.Random;

@Component
public class Subscription implements GraphQLSubscriptionResolver {

    @Autowired
    private UserService userService;

    public Publisher<User> randomUser(String symbol) {

        Random random = new Random();
        return Flux.interval(Duration.ofSeconds(1))
                .map(num -> userService.createUser(symbol, random.nextInt()));
    }
}
