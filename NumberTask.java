package com.informatica.test;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberTask implements Runnable {

	AtomicInteger number;
	int maxValue;
	int threadNumber;
	int numberPrinted=0;
	public NumberTask(AtomicInteger number,
			int maxValue,int threadNumber) {
		this.number=number;
		this.maxValue=maxValue;
		this.threadNumber=threadNumber;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			synchronized (number) {
				while(number.get()<=maxValue) {
				//System.out.println("Thread" + threadNumber);
				while(!(number.get()%this.threadNumber==0)) {
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				System.out.println("Thread" + threadNumber + "Printing: " +number.get() );
				//numberPrinted=number.get();
				number.incrementAndGet();
				if(number.get()%2!=0 
						&& number.get()%3!=0 && number.get()%5!=0)
					number.incrementAndGet();
				
				number.notifyAll();
			}
			
			
		}
		
		
	}
	
	
	
	
}


/*
 * User 
 * ----
 * UserId
 * Name
 * 
 * 
 * Event
 * -----
 * id
 * startTime
 * endTime
 * Status
 * 
 * 
 * Seat Booking
 * ------
 * SeatId
 * EventId
 * UserId
 * 
 * Seat
 * -----
 * SeatId
 * Seat Name
 * 
 * Seat Id 	EventId  UserId
 * 1		1			1
 * 
 * 
 * 
 * 
 * select s.seatId,
 * CASE select 1 from seat_booking where seat_id=s.seatid  then "b" ELSE "nb" 
 * from Seat s, Seat_booking sb
 * where s.seat_id*=sb.seat_id;
 * 
 * 
 * 
 * Order of Events
 * 
 * E2
 * E3
 * E1
 * E2
 * 
 * 
 * E3->E1->E2
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 Dog extends Animal

Dog {
    print(){ Sop("DOG"); }
}


Animal {
    print(){ Sop("Animal"); }
}


List<Dog> dogs= new ArrayList<>();
dogs.add(new Dog());
dogs.add(new Dog());

List<Animal> animals = new ArrayList<>();

animals = dogs;

animals.forEach(a->a.print()); 
 * 
 * 
 * 
 * 
 * 
 * 
*/