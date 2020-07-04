class SportsVehicle extends Vehicle{
    int turbo;
 // All getter and setter methods
	public int getTurbo() {
		return turbo;
	}

	public void setTurbo(int turbo) {
		this.turbo = turbo;
	}
	
	public SportsVehicle(String model,int enginePower, int tireSize,int turbo) {
		super(VehicleType.SPORTS, model, EngineType.OIL, enginePower, tireSize);
		this.turbo=turbo;
		
	}
	
}