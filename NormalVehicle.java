class NormalVehicle extends Vehicle{
	public NormalVehicle(String model,EngineType engineType,int enginepower, int tireSize) {
		// TODO Auto-generated constructor stub
		this.vehicleType="NORMAL";
		this.model=model;
		this.engineType=engineType;
		this.enginePower=enginepower;
		this.tireSize=tireSize;
	}
}