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
@Table(name ="customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY  )
	private long id;
	
	
	@Column(name="name")
	private String name;
	
	
	@OneToOne // bire bir ilişki 1 customer 1 addressi var demek .
	private Address address; // adres tablosu /classı ile  arasındaki bağlantıyı sağlamak için kullanırız .
	
	
	/// ilk bu kısımdan ilişki attık o yüzden burası ilişkininn sahibi dir 
	///
	
	/// customer tablosuna ilişkiden dolayı ve customer ilişkininn sahibi olduğu için (adreste mappedBy kullandık o yüzden)  customer tablosunda adress_id kolonu oluşturulur 
	///ama bu durum adreste olmaz 
	
}
