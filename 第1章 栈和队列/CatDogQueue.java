package queue;

import java.util.LinkedList;
import java.util.Queue;


/*
 * 实现一种狗猫队列的结构，要求如下:
 * 
    用户可以调用add方法将cat类或dog类的实例放入队列中;
    用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出;
    用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出;
    用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出;
    用户可以调用isEmpty方法，检查队列中是否还有log或cat的实例;
    用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例;
    用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
    
  Solution:
   1. 用两个队列，分别加入dog 和 cat
   2. 对加入的对象加上时间戳， 用于比较先后顺序
    
 * */
public class CatDogQueue {
	public Queue<PetWithTime> dogQueue;
	public Queue<PetWithTime> catQueue;
	int time;

	/**
	 * 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
	 * 
	 * LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
	 */
	public CatDogQueue() {
		dogQueue = new LinkedList<PetWithTime>();
		catQueue = new LinkedList<PetWithTime>();
	}

	public void add(Pet pet) {
		PetWithTime petWithTime = new PetWithTime(pet, time++);
		if (petWithTime.pet.type.endsWith("dog")) {
 			dogQueue.add(petWithTime);
		} else if (petWithTime.pet.type.endsWith("cat")) {
			catQueue.add(petWithTime);
		}
	}

	public void pollAll() {
		PetWithTime p1 = null;
		PetWithTime p2 = null;
		if (!dogQueue.isEmpty()) {
			p1 = dogQueue.peek();
		}
		if (!catQueue.isEmpty()) {
			p2 = catQueue.peek();
		}

		if (p1 == null && p2 == null) {
			time = 0;
			return;
		}

		if (p1 != null && p2 == null) {
			dogQueue.poll();
		}

		if (p1 == null && p2 != null) {
			catQueue.poll();
		}

		if (p1 != null && p2 != null) {
			if (p1.time < p2.time) {
				dogQueue.poll();
			} else {
				catQueue.poll();
			}
		}

		pollAll();
	}

	public void pollDog() {
		PetWithTime p1 = null;
		if (!dogQueue.isEmpty()) {
			p1 = dogQueue.peek();
		}

		if (p1 != null) {
			dogQueue.poll();
		}
		
		if (p1 == null) {
			return;
		}

		pollDog();
	}

	public void pollCat() {
		PetWithTime p1 = null;
		if (!catQueue.isEmpty()) {
			p1 = catQueue.peek();
		}

		if (p1 != null) {
			catQueue.poll();
		}
		
		if (p1 == null) {
			return;
		}

		pollCat();
	}

	public boolean isEmpty() {
		if (dogQueue.isEmpty() && catQueue.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isDogEmpty() {
		if (dogQueue.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isCatEmpty() {
		if (catQueue.isEmpty()) {
			return true;
		}
		return false;
	}

	class PetWithTime {
		public Pet pet;
		public int time;

		public PetWithTime(Pet pet, int time) {
			this.pet = pet;
			this.time = time;
		}

	}
	
	public static void main(String[] args) {
		CatDogQueue catDogQueue = new CatDogQueue();
		catDogQueue.add(new Dog());
		catDogQueue.add(new Dog());
		catDogQueue.add(new Cat());
		catDogQueue.add(new Cat());
		catDogQueue.add(new Dog());
		catDogQueue.add(new Cat());
		
		catDogQueue.pollAll();
		
		catDogQueue.add(new Dog());
		catDogQueue.add(new Dog());
		catDogQueue.add(new Cat());
		catDogQueue.add(new Cat());
		catDogQueue.add(new Dog());
		catDogQueue.add(new Cat());
		
		catDogQueue.pollCat();
		boolean empty = catDogQueue.isCatEmpty();
		empty = catDogQueue.isDogEmpty();
	}

}
