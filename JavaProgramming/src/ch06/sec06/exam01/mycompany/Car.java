package ch06.sec06.exam01.mycompany;

import ch06.sec06.exam01.hankook.*;
import ch06.sec06.exam01.hyundae.*;

public class Car {
	//Field
	Engine engine;
	SnowTire st = new SnowTire();

	
	Tire tire3 = new Tire();

	//constructor
	Car(){
		engine = new Engine();
	}
	

}
