package com.canoz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {


	
	@Column(name="description")
	private String description;
	
	@Id
	@GeneratedValue(strategy=  GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne (mappedBy = "address")// adres kısmından da bağlamış olduk 
	private Customer customer;
	
	/// ilk olarak customerden buraya bir ilşiki yazdık orası sahibi olacak ilişkinini
	///bunu belirtmek için mapperby kısmına customered tanımlanmış adres türünde  değişkeninin  ismini verdik 
	
	
	 // ilişki sahibi olmayan ksıma yazılır 
}
