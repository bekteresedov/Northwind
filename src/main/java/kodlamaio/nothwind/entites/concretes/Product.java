package kodlamaio.nothwind.entites.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // butun set ve get metodlar
@AllArgsConstructor // dolu
@NoArgsConstructor // bosh
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1 1 artmagin
	@Column(name = "product_id")
	private int id;

//	@Column(name = "category_id")
//	private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "productuantity_per_unit")
	private String quantityPerUnit;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

}
