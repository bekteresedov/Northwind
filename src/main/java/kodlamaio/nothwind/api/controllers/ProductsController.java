package kodlamaio.nothwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.httpserver.Authenticator.Result;

import kodlamaio.nothwind.business.abstracts.ProductService;
import kodlamaio.nothwind.core.utilites.results.DataResult;
import kodlamaio.nothwind.entites.concretes.Product;
import kodlamaio.nothwind.entites.dtos.ProductWithCategoryDto;

@RestController
@CrossOrigin(origins = "localhost:3000")
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();

	}
	@GetMapping("/getProductWithCategoryDto")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDto() {
		return this.productService.getProductWithCategoryDetails();

	}

	@PostMapping("/add")
	public kodlamaio.nothwind.core.utilites.results.Result add(@RequestBody Product product) {
		return productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategory")
	public 	DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategory(productName, categoryId);
		
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
}
