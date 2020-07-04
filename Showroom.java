import java.util.ArrayList;
import java.util.Scanner;

public class Showroom{
	static int visitorCount=30;
	static int normalVcount=0;
	static int sportsVCount=0;
	static int heavyVcount=0;
	static ArrayList<Vehicle> vehicleList= new ArrayList<Vehicle>();
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		print("\t WELCOME to the Vehicle Showroom \n");
		while(true) {
			print("Enter the numbers associated with the options");

			print("\t1.Add vehicles\n"
				+ "\t2.Remove vehicle\n"
				+ "\t3.See list of vehicles with details\n");
			int response=getIntValue();
			switch (response) {
			case 1:
				addVehicle();
				break;
			case 2:
				removeVehicle();
				break;
			case 3:
				showVehicleList();
				break;
			default:
				break;
			}
		}
	}
	static void showVehicleList() {
		if(vehicleList.isEmpty()) {
			print("Sorry, We don't have any vehicles yet. Please come back later");
		}
		else {
			print("Hello Sir, we have "+normalVcount+" Normal vehicles,"+sportsVCount+" Sport vehicles and "+heavyVcount+ " Heavy vehicles");
			for (Vehicle vehicle : vehicleList) {
				print(vehicle.getVehicleType()+" vehicle\n"
					+ "\tModel: "+vehicle.getModel()+"\n"
					+ "\tEngineType: "+vehicle.getEngineType()+"\n"
					+ "\tEnginePower: "+vehicle.getEnginePower()+"cc\n"
					+ "\tTireSeize: "+vehicle.getTireSize()+"inch");
				if(vehicle instanceof SportsVehicle){
					print("\tTurbo:"+((SportsVehicle) vehicle).getTurbo()+"mm");
				}
				if(vehicle instanceof HeavyVehicle){
					print("\tWeight:"+((HeavyVehicle)vehicle).getWeight()+"kg");
				}	
				print("\tVehicle ID: "+vehicle.getuID()+"\n");
			}
			print("You can expect "+visitorCount+" visitors");
		}
		
	}
	static void addVehicle(){
		print("\t\tWhich type of vehicle you want to add\n");
		print("\t\t1.Normal\n"
				+ "\t\t2.Sports\n"
				+ "\t\t3.Heavy");
		int type=getIntValue();
		sc.nextLine();
		switch (type) {
		case 1:
			vehicleList.add(addNormalVehicle());
			break;
		case 2:
			vehicleList.add(addSportsVehicle());
			break;
		case 3:
			vehicleList.add(addHeavyVehicle());
			break;
		default:
			break;
		}
	}
	
	static Vehicle addNormalVehicle() {
		print("Model:(string) ");
		String model=sc.nextLine();
		print("Engine Type:\n"
				+ "\t1.Oil\n"
				+ "\t2.Gas\n"
				+ "\t3.Diesel\n");
		int eType=getIntValue();
		EngineType engineType = null;
		switch (eType) {
		case 1:
			engineType=EngineType.OIL;
			break;
		case 2:
			engineType=EngineType.GAS;
			break;
		case 3:
			engineType=EngineType.DIESEL;
			break;
		default:
			break;
		}
		print("Engine Power(cc):(int) ");
		int enginePower=getIntValue();
		print("Tire Size(inch):(int) ");
		int tireSize=getIntValue();
		normalVcount++;
		NormalVehicle vehicle=new NormalVehicle(model,engineType,enginePower,tireSize);
		return vehicle;
	}
	static Vehicle addSportsVehicle() {
		print("Model:(string) ");
		String model=sc.nextLine();
		print("Engine Power(cc):(int) ");
		int enginePower=getIntValue();
		print("Tire Size(inch):(int) ");
		int tireSize=getIntValue();
		print("Turbo(mm):(int) ");
		int turbo=getIntValue();
		SportsVehicle vehicle=new SportsVehicle(model,enginePower,tireSize,turbo);
		visitorCount+=20;
		sportsVCount++;
		return vehicle;
	}
	static Vehicle addHeavyVehicle() {
		print("Model:(string) ");
		String model=sc.nextLine();
		print("Engine Power(cc):(int) ");
		int enginePower=getIntValue();
		print("Tire Size(inch):(int) ");
		int tireSize=getIntValue();
		print("Weght(kg):(int) ");
		int weight=getIntValue();
		HeavyVehicle vehicle=new HeavyVehicle(model,enginePower,tireSize,weight);
		heavyVcount++;
		return vehicle;
	}
	
	static void removeVehicle() {
		sc.nextLine();
		print("Please enter the Unique ID of the vehicle you want to remove\n");
		String uid=sc.nextLine();
		boolean found=false;
		for (int i = 0; i < vehicleList.size(); i++) {
			if(vehicleList.get(i).getuID().equals(uid)) {
				found=true;
				if(vehicleList.get(i) instanceof SportsVehicle) {
					visitorCount-=20;
					sportsVCount--;
				} else if(vehicleList.get(i) instanceof HeavyVehicle) {
					heavyVcount--;
				} else {
					normalVcount--;
				}
				vehicleList.remove(i);
				print("Vehicle with Unique ID: "+uid +" has been removed successfully");
			}
		}
		if(!found) {
			print("Oops, there is no vehicle with this unique ID");
		}
	}
	static void print(Object o) {
		System.out.println(o);
	}
	static int getIntValue() {
		boolean intFound = false;
	    int value = 0;
	    do{
	        if(sc.hasNextInt()){
	            value = sc.nextInt();
	            intFound = true;
	        }else{
	            sc.nextLine();
	            System.out.println("Hey, Enter a valid Integer value");
	        }
	    }while(!intFound);
		return value;
	}

	
}