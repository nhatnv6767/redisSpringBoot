package redis.repo;

import org.springframework.data.repository.CrudRepository;
import redis.data.User;

public interface UserCrudRepository extends CrudRepository<User, String> {
}
