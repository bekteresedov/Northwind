package kodlamaio.nothwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.nothwind.business.abstracts.ProductService;
import kodlamaio.nothwind.core.utilites.results.DataResult;
import kodlamaio.nothwind.core.utilites.results.SuccesDataResult;
import kodlamaio.nothwind.core.utilites.results.SuccesResult;
import kodlamaio.nothwind.dataAccess.abstracts.ProductDao;
import kodlamaio.nothwind.entites.concretes.Product;
import kodlamaio.nothwind.entites.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>(productDao.findAll(), "Data eklendi");
	}

	@Override
	public kodlamaio.nothwind.core.utilites.results.Result add(Product product) {
		productDao.save(product);
		return new SuccesResult("Urun eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<Product>(productDao.getByProductName(productName), "Data eklendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
				"Data eklendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),
				"Data eklendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>(productDao.getByCategoryIn(categories), "Data eklendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>(productDao.getByProductNameContains(productName), "Data eklendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName), "Data eklendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryId),
				"Data eklendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return new SuccesDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
	Sort sort= Sort.by(Sort.Direction.DESC,"productName");
		return new SuccesDataResult<List<Product>>(this.productDao.findAll(sort));
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<ProductWithCategoryDto>>(productDao.getProductWithCategoryDetails(), "Data eklendi");
	}
	}


