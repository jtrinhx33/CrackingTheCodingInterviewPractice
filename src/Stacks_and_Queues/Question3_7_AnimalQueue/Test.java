package Stacks_and_Queues.Question3_7_AnimalQueue;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnimalQueue adoptionCenter = new AnimalQueue();
		
		adoptionCenter.enqueue(new Dog("dog1"));
		adoptionCenter.enqueue(new Dog("dog2"));
		adoptionCenter.enqueue(new Dog("dog3"));
		adoptionCenter.enqueue(new Dog("dog4"));
		adoptionCenter.enqueue(new Cat("cat1"));
		adoptionCenter.enqueue(new Cat("cat2"));
		adoptionCenter.enqueue(new Dog("dog5"));

		/*System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);*/
		
		//System.out.println(adoptionCenter.dequeueAny().name);
		//System.out.println(adoptionCenter.dequeueAny().name);
		//System.out.println(adoptionCenter.dequeueDog().name);
		System.out.println(adoptionCenter.dequeueCats().name);
		System.out.println(adoptionCenter.dequeueDogs().name);
		System.out.println(adoptionCenter.dequeueCats().name);
		
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
		System.out.println(adoptionCenter.dequeueAny().name);
	}

}
