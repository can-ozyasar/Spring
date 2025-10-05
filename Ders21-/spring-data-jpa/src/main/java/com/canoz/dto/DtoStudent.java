package com.canoz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent { // bu sınıfı oluşturmamızdaki amaaç kullanıcı tüm student verilerini görmesin sadece dto da olan lar ile işlem yapabilsin 
	// get set post gibi işlemler hepsi dto üzerinden yapılacak bu sayede gizli verilerimiz korunacak kullanıcı tarafından görüntelenemeyecek 

	 private String firstName; // student.java daki aynı değişkeninismi  ile aynı ismi  vermeliyiz .
	 
	 
	 
	 private String lastName;

	 // örnek olarak stundent.java da olan birthOfDate değişkennini kullanıcı görmesini istemediğimiz için burada yazmadık .bu gizli bir veri olsun 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
