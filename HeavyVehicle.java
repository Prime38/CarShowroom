public class HeavyVehicle extends Vehicle{
	int weight;
	public HeavyVehicle(String model,int enginePower, int tireSize,int weight) {
		super(VehicleType.HEAVY, model, EngineType.DIESEL, enginePower, tireSize);
		this.weight=weight;
		
	}
	// All getter and setter methods
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}