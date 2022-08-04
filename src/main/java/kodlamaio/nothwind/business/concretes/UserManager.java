package kodlamaio.nothwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.nothwind.business.abstracts.UserService;
import kodlamaio.nothwind.core.dataAccess.UserDao;
import kodlamaio.nothwind.core.entities.User;
import kodlamaio.nothwind.core.utilites.results.DataResult;
import kodlamaio.nothwind.core.utilites.results.Result;
import kodlamaio.nothwind.core.utilites.results.SuccesDataResult;
import kodlamaio.nothwind.core.utilites.results.SuccesResult;
@Service
public class UserManager implements UserService {
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccesResult("Kullanici eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {

		return new SuccesDataResult<User>(this.userDao.findByEmail(email),"Kullanici bulundu");
	}

}
