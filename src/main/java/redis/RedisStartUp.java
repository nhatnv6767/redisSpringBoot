package redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.data.User;
import redis.pubsub.RedisMessagePublisher;
import redis.repo.UserCrudRepository;
import redis.repo.UserRepository;

@SpringBootApplication
public class RedisStartUp {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(RedisStartUp.class, args);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        UserCrudRepository userCrudRepository = applicationContext.getBean(UserCrudRepository.class);
        User user = new User();
        user.setUsername("Nhatnguyen");
        user.setDisplayName("Administrator");
        userRepository.saveUser(user);

        User fetchedUser = userCrudRepository.findById("Nhatnguyen").get();
        System.out.println(fetchedUser);

        RedisMessagePublisher messagePublisher = applicationContext.getBean(RedisMessagePublisher.class);
        messagePublisher.publish("Hello Nhatnguyen");

        while (true){
            Thread.sleep(100);
        }

    }
}
