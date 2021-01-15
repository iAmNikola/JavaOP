package modules;

import java.util.Objects;

public class PlumbingRepair {
	private int repairNo;
	private String plumberID;
	private int cost;
	private int price;
	private String datetime;
	
	public PlumbingRepair(){
		
	}
	
	public PlumbingRepair(int repairNo, String plumberID, int cost, int price, String datetime) {
		this.repairNo = repairNo;
		this.plumberID = plumberID;
		this.cost = cost;
		this.price = price;
		this.datetime = datetime;
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(this.repairNo, this.plumberID, this.cost, this.price, this.datetime);
    }

	public int getRepairNo() {
		return repairNo;
	}

	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}

	public String getPlumberID() {
		return plumberID;
	}

	public void setPlumberID(String plumberID) {
		this.plumberID = plumberID;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
