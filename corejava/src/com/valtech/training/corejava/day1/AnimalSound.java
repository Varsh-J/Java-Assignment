package com.valtech.training.corejava.day1;

public class AnimalSound {
	public void disturb(Animal a) {
		a.makeSound();
	}
	public static void main(String[] args) {
		AnimalSound a =new AnimalSound();
		a.disturb(new Dog());
		a.disturb(new Cat());
		
	}

}
