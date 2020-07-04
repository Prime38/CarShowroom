public class HeavyVehicle extends Vehicle{
	int weight;
	// All getter and setter methods
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public HeavyVehicle(String model,int enginepower, int tireSize,int weight) {
		this.model=model;
		this.enginePower=enginepower;
		this.tireSize=tireSize;
		this.weight=weight;
		this.engineType=EngineType.DIESEl;
	}
}