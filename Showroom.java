import java.util.ArrayList;
import java.util.Scanner;

public class Showroom{
	static int visitorCount=30;
	static ArrayList<Vehicle> vehicleList= new ArrayList<Vehicle>();
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		print("\t WELCOME to the Vehicle Showroom \n You can \n");
		while(true) {
			print("You can expect "+visitorCount+" visitors");

			print("\t1.Add vehicles\n"
				+ "\t2.Remove vehicle\n"
				+ "\t3.See list of vehicles with details\n");
			int response=sc.nextInt();
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
		for (Vehicle vehicle : vehicleList) {
			print(vehicle.getVehicleType()+" vehicle\n"
				+ "\tModel: "+vehicle.getModel()+"\n"
				+ "\tEngineType: "+vehicle.getEngineType()+"\n"
				+ "\tEnginePower: "+vehicle.getEnginePower()+"\n"
				+ "\tTireSeize: "+vehicle.getTireSize());
			if(vehicle instanceof SportsVehicle){
				print("\tTurbo:"+((SportsVehicle) vehicle).getTurbo());
			}
			if(vehicle instanceof HeavyVehicle){
				print("\tWeight:"+((HeavyVehicle)vehicle).getWeight());
			}	
			print("\tVehicle ID: "+vehicle.getuID()+"\n");
		}
		print("You can expect "+visitorCount+" visitors");
	}
	static void addVehicle(){
		print("\t\tWhich type of vehicle you want to add\n");
		print("\t\t1.Normal\n"
				+ "\t\t2.Sports\n"
				+ "\t\t3.Heavy");
		int type=sc.nextInt();
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
		print("Model: ");
		String model=sc.nextLine();
		print("Engine Type:\n"
				+ "\t1.Oil\n"
				+ "\t2.Gas\n"
				+ "\t3.Diesel\n");
		int eType=sc.nextInt();
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
		print("Engine Power: ");
		int enginePower=sc.nextInt();
		print("Tire Size: ");
		int tireSize=sc.nextInt();
		NormalVehicle vehicle=new NormalVehicle(model,engineType,enginePower,tireSize);
		return vehicle;
	}
	static Vehicle addSportsVehicle() {
		print("Model: ");
		String model=sc.nextLine();
		print("Engine Power: ");
		int enginePower=sc.nextInt();
		print("Tire Size: ");
		int tireSize=sc.nextInt();
		print("Turbo: ");
		int turbo=sc.nextInt();
		SportsVehicle vehicle=new SportsVehicle(model,enginePower,tireSize,turbo);
		visitorCount+=20;
		return vehicle;
		
	}
	static Vehicle addHeavyVehicle() {
		print("Model: ");
		String model=sc.nextLine();
		print("Engine Power: ");
		int enginePower=sc.nextInt();
		print("Tire Size: ");
		int tireSize=sc.nextInt();
		print("Weght: ");
		int weight=sc.nextInt();
		HeavyVehicle vehicle=new HeavyVehicle(model,enginePower,tireSize,weight);
		return vehicle;
		
	}
	
	static void removeVehicle() {
		
	}
	static void print(Object o) {
		System.out.println(o);
	}
	
 
}
/*
1
1
BMW
1
2400
50
*/