package queue;

import java.util.LinkedList;
import java.util.Queue;


/*
 * ʵ��һ�ֹ�è���еĽṹ��Ҫ������:
 * 
    �û����Ե���add������cat���dog���ʵ�����������;
    �û����Ե���pollAll�����������������е�ʵ�����ս����е��Ⱥ�˳�����ε���;
    �û����Ե���pollDog��������������dog���ʵ�����ս����е��Ⱥ�˳�����ε���;
    �û����Ե���pollCat��������������cat���ʵ�����ս����е��Ⱥ�˳�����ε���;
    �û����Ե���isEmpty���������������Ƿ���log��cat��ʵ��;
    �û����Ե���isDogEmpty���������������Ƿ���dog���ʵ��;
    �û����Ե���isCatEmpty���������������Ƿ���cat���ʵ����
    
  Solution:
   1. ���������У��ֱ����dog �� cat
   2. �Լ���Ķ������ʱ����� ���ڱȽ��Ⱥ�˳��
    
 * */
public class CatDogQueue {
	public Queue<PetWithTime> dogQueue;
	public Queue<PetWithTime> catQueue;
	int time;

	/**
	 * ������һ����������Ա���ֻ�����ڱ��ǰ�˽���ɾ�����������ڱ�ĺ�˽��в��������
	 * 
	 * LinkedList��ʵ����Queue�ӿڣ�������ǿ��԰�LinkedList����Queue���á�
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
