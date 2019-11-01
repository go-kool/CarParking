package com.classKlap.parkingLot;

import java.util.Scanner;

public class App 
{
	static int i=0;
	public static void menu() {
			System.out.println("MENU");
			if(i==0) {
			System.out.println("1. CREAT A PARKING LOT");
			System.out.println("2. EXIT");
			}
			else {
				System.out.println("1. PARK A CAR");
				System.out.println("2. REMOVE CAR FROM PARKING");
				System.out.println("3. STATUS OF PARKING SLOT");
				System.out.println("4. REGISTRATION NUMBERS OF CAR FOR A PARTICULAR COLOR");
				System.out.println("5. SLOT NUMBERS OF CAR FOR A PARTICULAR COLOR");
				System.out.println("6. SLOT NUMBER OF CAR FOR A PARTICULAR REGISTRATION NUMBER");
				System.out.println("7. EXIT");
			}
	}
	
    public static void main( String[] args )
    {
    	ParkingLot parkingLot =new ParkingLot();
		while(true)
		{
			menu();
			Scanner sc= new Scanner(System.in);
			int option =sc.nextInt();
			
			switch(option)
			{
				case 1:
					if(i==0) {
						System.out.println("Enter the Size of the Parking Lot");
						int size=sc.nextInt();
						if(size >0)
							i++;
						System.out.println(parkingLot.createParkingSloat(size));
					}	
					else {
						if(parkingLot.getParkingSlots().size() == 0)
							System.out.println("Sorry, parking lot is full");
						else {	
							System.out.println("Enter the car number");
							String carNumber=sc.next();
							System.out.println("Enter the car color");
							String carColor=sc.next();
							System.out.println(parkingLot.parkACar(carNumber, carColor));
						}
					}
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
				case 2:
					if(i==0)
					{	
						i++;
						System.exit(0);
					}
					else {
						System.out.println("Enter the slot number");
						System.out.println(parkingLot.removingACarFromASlot(sc.nextInt()));
						
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					if(i==0)
						System.out.println("Wrong Input please try again");
					else {
						System.out.println(parkingLot.status());
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					if(i==0)
						System.out.println("Wrong Input please try again");
					else {
						System.out.println("Enter the color of Car");
						System.out.println(parkingLot.regNumberOfCarForAColor(sc.next().trim().split(" ")[0]));
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					if(i==0)
						System.out.println("Wrong Input please try again");
					else {
						System.out.println("Enter the color of Car");
						System.out.println(parkingLot.slotNumberOfCarForAColor(sc.next().trim().split(" ")[0]));
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:
					if(i==0)
						System.out.println("Wrong Input please try again");
					else {
						System.out.println("Enter the Registration number");
						System.out.println(parkingLot.slotNumberOfCarForRegNumber(sc.next().trim().split(" ")[0]));
					}
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:
					System.exit(0);
					
				default:
					System.out.println("Wrong Input please try again");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
			}
		}
    }
}
