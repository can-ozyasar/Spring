package com.canoz.dto;

import java.sql.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU { // bu class ı şu yüzden açtık 
	// şimdi dtostudent get işlemlerinde iyi ama save işlemleri için eksik veriler içeriyor 
	// örnek olarak student eklemek için isim soyisiism birthdate lazım ama biz dto da birthofdate yi kullanmadık bilerek
	// bu yüzden de yeni eleman ekleme gibi bazı işlemelrde dto student yetersiz kalıyor 
	
	// bizde dtostudent ıu  isminde (insort update)  isimli bir class daha oluşturduk güncelleme ekleme işlemeleinde bunu kullanacağız .
	// get işlemelerinde ise dto yu kullanacağız 
	
	
	/// DERS 30 SPRİNG VALİDATİON
	///
	
//@Null — Null olur.
//@NotNull — Null olamaz.
//@Pattern — Yazılan RegEx paterni
//@NotEmpty — Boş ya da boş olamaz.
//@NonBlank — Boşluk ya da null olamaz.
//@Email — E-posta formatını doğrular
//@AssertTrue — Değer doğru
//@AssertFalse — Değer yanlış
//@Min — Büyük veya eşit
//@Max — Küçük veya eşit
//@Negative — Negatif zorunludur.
//@NegativeOrZero — 0 ya da negatif zorunluluk
//@Positive — Pozitif Zorunlu
//@PositiveOrZero — 0 ya da pozitif.
//@Size — size'ın verilen aralıkta olması gerekir.
//@Past — Geçmiş tarih olmalıdır.
//@PastOrPresent — Geçmiş tarih ya da mevcut bir tarih olmalıdır.
//@Future — Gelecek tarih olmalı.
//@FutureOrPresent — Gelecek tarih ya da mevcut tarih olmalıdır.
//@CreditCardNumber — Kredi kartı formatı
//@Currency — Değer kontrolü
//@EAN — EAN biçimi
//@ISBN — ISBN formatı
//@Length — Verili olmalıdır.

	
	
	/// JAVADA BLANK NULL VE EMTY KAVRAM FARKLARI
	/// String A =null ------- null
	///String A ;      ------- blank 
	///String A = "";  ------- emty
	
@NotEmpty(message="FirstName alanı boş bırakılamaz.")
//@Min(value = 3, message = "FirstName değişkeni en az 3 karakter olabilir ") // en az 3 karakter olsun .
//@Max(value = 10)
//@Size(min = 3,max = 10) // üsteki ile aynı işlemleri tek bi yerde toplar size 
private String firstName;
// anatasyonu yazarız ama bazen çalışmaz çünkü veri tabanına takılabilir kurallar 
// kuralların aktif olması için o değişken kodda nerede varsa önüne @valid eklemek gerekir .


private String lastName;


private  Date birthOfDate;

@Email(message = "e mail formatınızda hata var !! ")
private String eMail;

//@Size(min=11,max=11 ,message="tckn 11 hane olmalı")
@NotEmpty(message="TCKN alan boş geçilemez")
private String TcKimlik;



}
