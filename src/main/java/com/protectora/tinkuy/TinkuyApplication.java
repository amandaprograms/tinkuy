package com.protectora.tinkuy;

import com.protectora.tinkuy.entities.*;
import com.protectora.tinkuy.enumerations.*;
import com.protectora.tinkuy.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class TinkuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinkuyApplication.class, args);
	}

//	@Bean
//    CommandLineRunner initData(AnimalServiceImpl animalServiceImpl, RazaServiceImpl razaServiceImpl, EspecieServiceImpl especieServiceImpl, ImagenAnimalServiceImpl imagenAnimalServiceImpl, FichaAnimalCompletaServiceImpl fichaAnimalCompletaServiceImpl){
//		return args -> {
//
//			Especie especie1 = new Especie(null, "perro");
//			Especie especie2 = new Especie(null, "gato");
//
//			especieServiceImpl.agregar(especie1);
//			especieServiceImpl.agregar(especie2);
//
//			Raza raza1 = new Raza(null, "Mestizo", especie1);
//			Raza raza2 = new Raza(null, "Pitbull", especie1);
//			Raza raza3 = new Raza(null, "Pastor Alemán", especie1);
//			Raza raza4 = new Raza(null, "Labrador", especie1);
//			Raza raza5 = new Raza(null, "Galgo", especie1);
//			Raza razaGato1 = new Raza(null, "Común Europeo", especie2);
//			Raza razaGato2 = new Raza(null, "Siamés", especie2);
//			Raza razaGato3 = new Raza(null, "Persa", especie2);
//
//			razaServiceImpl.agregar(raza1);
//			razaServiceImpl.agregar(raza2);
//			razaServiceImpl.agregar(raza3);
//			razaServiceImpl.agregar(raza4);
//			razaServiceImpl.agregar(raza5);
//			razaServiceImpl.agregar(razaGato1);
//			razaServiceImpl.agregar(razaGato2);
//			razaServiceImpl.agregar(razaGato3);
//
//			Animal animal1 = new Animal (null, "Luna", SexoAnimalEnum.HEMBRA, TamanoAnimalEnum.MEDIANO, LocalDate.of(2023,2,1), true, true, false, raza1);
//			Animal animal2 = new Animal (null, "Nemo", SexoAnimalEnum.MACHO, TamanoAnimalEnum.GRANDE, LocalDate.of(2020,10,2), false, false, true, raza2);
//			Animal animal3 = new Animal (null, "Thor", SexoAnimalEnum.MACHO, TamanoAnimalEnum.PEQUENO, LocalDate.of(2025,11,17), true, true, false, raza1);
//			Animal animal4 = new Animal(null, "Rocky", SexoAnimalEnum.DESCONOCIDO, TamanoAnimalEnum.GRANDE, LocalDate.of(2021, 5, 10), true, true, false, raza3);
//			Animal animal5 = new Animal(null, "Canela", SexoAnimalEnum.HEMBRA, TamanoAnimalEnum.PEQUENO, LocalDate.of(2026, 3, 15), false, false, false, raza1);
//			Animal animal6 = new Animal(null, "Zeus", SexoAnimalEnum.MACHO, TamanoAnimalEnum.GRANDE, LocalDate.of(2017, 8, 20), true, null, true, raza2);
//			Animal animal7 = new Animal(null, "Lola", SexoAnimalEnum.HEMBRA, TamanoAnimalEnum.MEDIANO, LocalDate.of(2022, 6, 12), true, true, null, raza4);
//			Animal animal8 = new Animal(null, "Sombra", SexoAnimalEnum.HEMBRA, TamanoAnimalEnum.GRANDE, LocalDate.of(2015, 2, 10), true, true, false, raza5);
//			Animal animal9 = new Animal(null, "Michi", SexoAnimalEnum.MACHO, TamanoAnimalEnum.PEQUENO, LocalDate.of(2022, 4, 10), true, true, false, razaGato1);
//			Animal animal10 = new Animal(null, "Misi", SexoAnimalEnum.HEMBRA, TamanoAnimalEnum.PEQUENO, LocalDate.of(2026, 6, 5), false, false, false, razaGato2);
//			Animal animal11 = new Animal(null, "Simón", SexoAnimalEnum.MACHO, TamanoAnimalEnum.MEDIANO, LocalDate.of(2023, 9, 14), true, true, false, razaGato3);
//
//			animalServiceImpl.agregar(animal1);
//			animalServiceImpl.agregar(animal2);
//			animalServiceImpl.agregar(animal3);
//			animalServiceImpl.agregar(animal4);
//			animalServiceImpl.agregar(animal5);
//			animalServiceImpl.agregar(animal6);
//			animalServiceImpl.agregar(animal7);
//			animalServiceImpl.agregar(animal8);
//			animalServiceImpl.agregar(animal9);
//			animalServiceImpl.agregar(animal10);
//			animalServiceImpl.agregar(animal11);
//
//			FichaAnimalCompleta ficha1 = new FichaAnimalCompleta(animal1.getId(), animal1, "1234", LocalDateTime.now(), false, null, null, null, null, "Una perrita muy buena que...", true, true, true, true, null, true);
//			FichaAnimalCompleta ficha2 = new FichaAnimalCompleta(animal2.getId(), animal2, "5678", LocalDateTime.now(), true, MotivoUrgenciaEnum.SALUD, null, null, null, "Un perrito muy bueno que...", true, true, true, true, true, true);
//			FichaAnimalCompleta ficha4 = new FichaAnimalCompleta(animal4.getId(), animal4, "9012", LocalDateTime.now(), false, null, null, null, null, "Un perro muy activo y guardián...", true, true, true, true, false, true);
//			FichaAnimalCompleta ficha5 = new FichaAnimalCompleta(animal5.getId(), animal5, "3456", LocalDateTime.now(), true, MotivoUrgenciaEnum.SALUD, null, null, null, "Cachorrita rescatada de la calle...", true, true, true, true, true, true);
//			FichaAnimalCompleta ficha6 = new FichaAnimalCompleta(animal6.getId(), animal6, "7890", LocalDateTime.now(), false, null, null, null, null, "Abuelete muy tranquilo y cariñoso...", true, true, true, false, false, false);
//			FichaAnimalCompleta ficha7 = new FichaAnimalCompleta(animal7.getId(), animal7, "1122", LocalDateTime.now(), false, null, null, null, null, "Le encanta jugar con la pelota...", true, true, true, true, true, true);
//			FichaAnimalCompleta ficha8 = new FichaAnimalCompleta(animal8.getId(), animal8, "3344", LocalDateTime.now().minusMonths(6), false, null, null, LocalDate.of(2025, 1, 15), false, "Fue una compañera excepcional...", true, true, true, true, true, true);
//			FichaAnimalCompleta ficha9 = new FichaAnimalCompleta(animal9.getId(), animal9, "5566", LocalDateTime.now(), false, null, null, null, null, "Un gato muy casero, le encanta dormir al sol...", true, true, true, true, null, true);
//			FichaAnimalCompleta ficha10 = new FichaAnimalCompleta(animal10.getId(), animal10, "7788", LocalDateTime.now(), true, MotivoUrgenciaEnum.SALUD, null, null, null, "Gatita rescatada necesita adopción urgente...", true, true, true, true, true, true);
//
//			fichaAnimalCompletaServiceImpl.agregar(ficha1);
//			fichaAnimalCompletaServiceImpl.agregar(ficha2);
//			fichaAnimalCompletaServiceImpl.agregar(ficha4);
//			fichaAnimalCompletaServiceImpl.agregar(ficha5);
//			fichaAnimalCompletaServiceImpl.agregar(ficha6);
//			fichaAnimalCompletaServiceImpl.agregar(ficha7);
//			fichaAnimalCompletaServiceImpl.agregar(ficha8);
//			fichaAnimalCompletaServiceImpl.agregar(ficha9);
//			fichaAnimalCompletaServiceImpl.agregar(ficha10);
//
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-1-inicial-1.jpg", "Luna", 1, animal1));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-1-inicial-2.jpg", "Rocky", 1, animal4));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-3-inicial-1.jpg", "Canela", 1, animal5));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-4-inicial-1.jpg", "Zeus", 1, animal6));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-5-inicial-1.jpg", "Lola", 1, animal7));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-2-inicial-1.jpg", "Sombra", 1, animal8));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-6-inicial-1.jpg", "Michi", 1, animal9));
//			imagenAnimalServiceImpl.agregar(new ImagenAnimal(null, "animal-7-inicial-1.jpg", "Misi", 1, animal10));
//		};
//	}
}

