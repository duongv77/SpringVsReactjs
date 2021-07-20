package duong.dev.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@Table(name = "promotions")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sale")
	private Integer sale;

	@OneToMany
	@JoinColumn(
			name = "product_id",
			nullable = false,
			referencedColumnName = "id"
		)
	private List<Product> product;
	
	@OneToMany
	@JoinColumn(
			name = "promotiondetail_id",
			nullable = false,
			referencedColumnName = "id"
	)
	private List<Promotiondetail> promotiondetail;
}
