import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;


enum EngineType{
    OIL,GAS,DIESEL
}
enum VehicleType{
	NORMAL,SPORTS,HEAVY
}
class Vehicle{
	private VehicleType vehicleType;
	private String model;
    private EngineType engineType;
    private int enginePower;
    private int tireSize;
    private String uID;
    public Vehicle(VehicleType vehicleType,String model,EngineType engineType,int enginePower,int tireSize) {
    	this.uID = generateUID();
    	this.vehicleType=vehicleType;
		this.model=model;
		this.enginePower=enginePower;
		this.tireSize=tireSize;
		this.engineType=engineType;
    	
    }
    // All getter and setter methods
    public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getuID() {
		return uID;
	}
	
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
	private static String generateUID(){ //generate Unique ID for each vehicle
		String curTimeString= LocalDateTime.now().toString();
		String uid = null;
		try {
			uid = getSHA(curTimeString);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return uid;
	}
	
	private static String getSHA(String input) throws NoSuchAlgorithmException {  // return hash of a string
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        byte[] hash= md.digest(input.getBytes(StandardCharsets.UTF_8)); 
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32){  
            hexString.insert(0, '0');  
        }
        return hexString.toString();
    } 

}
