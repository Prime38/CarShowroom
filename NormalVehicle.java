class NormalVehicle extends Vehicle{
	public NormalVehicle(String model,EngineType engineType,int enginePower, int tireSize) {
		super(VehicleType.NORMAL, model, EngineType.OIL, enginePower, tireSize);
	}
}