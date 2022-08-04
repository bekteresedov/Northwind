package kodlamaio.nothwind.business.abstracts;

import java.util.List;

import kodlamaio.nothwind.core.entities.User;
import kodlamaio.nothwind.core.utilites.results.DataResult;
import kodlamaio.nothwind.core.utilites.results.Result;
import kodlamaio.nothwind.entites.concretes.Product;

public interface UserService {
	Result add(User user);

	DataResult<User> findByEmail(String email);
}
