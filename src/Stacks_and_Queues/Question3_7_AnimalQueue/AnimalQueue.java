package Stacks_and_Queues.Question3_7_AnimalQueue;

import java.util.LinkedList;

public class AnimalQueue {
	//LinkedList<Animal> queue;
	LinkedList<Dog> dogs;
	LinkedList<Cat> cats;
	private int order = 0; // Timestamp variable
	
	public AnimalQueue(){
		//queue = new LinkedList<Animal>();
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
	}
	
	public void enqueue(Animal animal){
		if (animal == null){
			return;
		}
		//queue.add(animal);
		
		animal.setOrder(order);
		order++;
		
		if (animal instanceof Dog) 
			dogs.addLast((Dog)animal);
		else if (animal instanceof Cat) 
			cats.addLast((Cat) animal);
	}
	
	public Animal dequeueAny(){
		//if (queue.isEmpty()) return null;
		//return queue.removeFirst();
		
		// Looks at tops of dog and cat queues, and pop the stack with the oldest value
		if (dogs.size() == 0){
			return dequeueCats();
		}
		else if (cats.size() == 0){
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)){
			return dequeueDogs();
		}
		else {
			return dequeueCats();
		}
	}
	
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	
	public Cat dequeueCats(){
		return cats.poll();
	}
	
	
	/*
	public Dog dequeueDog(){
		if (queue.isEmpty()) return null;
		
		for (int ii = 0; ii < queue.size(); ii++){
			if (queue.get(ii).getClass() == Dog.class)
				return (Dog)queue.remove(ii);
		}
		
		return null;
	}
	
	public Cat dequeueCat(){
		if (queue.isEmpty()) return null;
		
		for (int ii = 0; ii < queue.size(); ii++){
			if (queue.get(ii).getClass() == Cat.class)
				return (Cat)queue.remove(ii);
		}
		
		return null;
	}*/
}
