
public class wine {
	private String type;//color
	private Float fixedAcidity;
	private Float volatileAcidity;
	private Float citricAcid;
	private Float residualSugar;
	private Float chlorides;
	private Float freeSulfur;
	private Float totalSulfur;
	private Float density;
	private Float pH;
	private Float sulphates;
	private Float alcohol;
	private Integer quality;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getFixedAcidity() {
		return fixedAcidity;
	}
	public void setFixedAcidity(float fixedAcidity) {
		this.fixedAcidity = fixedAcidity;
	}
	public float getVolatileAcidity() {
		return volatileAcidity;
	}
	public void setVolatileAcidity(float volatileAcidity) {
		this.volatileAcidity = volatileAcidity;
	}
	public float getCitricAcid() {
		return citricAcid;
	}
	public void setCitricAcid(float citricAcid) {
		this.citricAcid = citricAcid;
	}
	public float getResidualSugar() {
		return residualSugar;
	}
	public void setResidualSugar(float residualSugar) {
		this.residualSugar = residualSugar;
	}
	public float getChlorides() {
		return chlorides;
	}
	public void setChlorides(float chlorides) {
		this.chlorides = chlorides;
	}
	public float getFreeSulfur() {
		return freeSulfur;
	}
	public void setFreeSulfur(float freeSulfur) {
		this.freeSulfur = freeSulfur;
	}
	public float getTotalSulfur() {
		return totalSulfur;
	}
	public void setTotalSulfur(float totalSulfur) {
		this.totalSulfur = totalSulfur;
	}
	public float getDensity() {
		return density;
	}
	public void setDensity(float density) {
		this.density = density;
	}
	public float getpH() {
		return pH;
	}
	public void setpH(float pH) {
		this.pH = pH;
	}
	public float getSulphates() {
		return sulphates;
	}
	public void setSulphates(float sulphates) {
		this.sulphates = sulphates;
	}
	public float getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(float alcohol) {
		this.alcohol = alcohol;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	//get attribute by name
	public Object getByName(String a) {
		if(a.equals("color")) 
			return type;
		else if(a.equals("fixed acidity"))
			return fixedAcidity;
		else if(a.equals("volatile acidity")) 
			return volatileAcidity;
		else if(a.equals("citric acid")) 
			return citricAcid;
		else if(a.equals("residual sugar"))
			return residualSugar;
		else if(a.equals("chlorides")) 
			return chlorides;
		else if(a.equals("free sulfur")) 
			return freeSulfur;
		else if(a.equals("total sulfur")) 
			return totalSulfur;
		else if(a.equals("density"))
			return density;
		else if(a.equals("pH")) 
			return pH;
		else if(a.equals("sulphates")) 
			return sulphates;	
		else if(a.equals("alcohol"))
			return alcohol;
		
		return null;
	}
	
}
