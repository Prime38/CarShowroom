class SportsVehicle extends Vehicle{
    int turbo;
 // All getter and setter methods
	public int getTurbo() {
		return turbo;
	}

	public void setTurbo(int turbo) {
		this.turbo = turbo;
	}
	
	public SportsVehicle(String model,int enginepower, int tireSize,int turbo) {
		this.model=model;
		this.enginePower=enginepower;
		this.tireSize=tireSize;
		this.turbo=turbo;
		this.engineType=EngineType.OIL;
	}
	
}