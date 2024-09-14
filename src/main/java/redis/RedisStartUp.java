package redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.data.User;
import redis.repo.UserRepository;

@SpringBootApplication
public class RedisStartUp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RedisStartUp.class, args);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        User user = new User();
        user.setUsername("Nhatnguyen");
        user.setDisplayName("Administrator");
        userRepository.saveUser(user);


    }
}
