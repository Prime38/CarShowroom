enum EngineType{
    OIL,GAS,DIESEl
}
class Vehicle{
    String model;
    EngineType engineType;
    int enginePower;
    int tireSize;
    // All getter and setter methods
    public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public EngineType getEngineType() {
		return engineType;
	}
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}
	public int getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}
	public int getTireSize() {
		return tireSize;
	}
	public void setTireSize(int tireSize) {
		this.tireSize = tireSize;
	}
	


}
