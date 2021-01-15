package modules;

import java.time.Month;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlumbingReport {
	public String plumberID;
    public Month month;
    public int totalEarnings;
    public int materialCostDif;
    public int costLow;
    public int costHigh;
    
    public PlumbingReport(String plumberID, Month month, int totalEarnings, int cost) {
        this.plumberID = plumberID;
        this.month = month;
        this.totalEarnings = totalEarnings;
        this.costLow = cost;
        this.costHigh = cost;
    }

	public String getPlumberID() {
		return plumberID;
	}

	public void setPlumberID(String plumberID) {
		this.plumberID = plumberID;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public int getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(int totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	
	public void addEarnings(int earnings) {
		this.totalEarnings += earnings;
	}

	public int getMaterialCostDif() {
		return materialCostDif;
	}

	public void setMaterialCostDif(int materialCostDif) {
		this.materialCostDif = materialCostDif;
	}
	@JsonIgnore
	public int getCostLow() {
		return costLow;
	}

	public void setCostLow(int costLow) {
		if (costLow<this.costLow) {
			this.costLow = costLow;
			this.materialCostDif = this.costHigh - costLow;
		}
	}
	@JsonIgnore
	public int getCostHigh() {
		return costHigh;
	}

	public void setCostHigh(int costHigh) {
		if (costHigh>this.costHigh) {
			this.costHigh = costHigh;
			this.materialCostDif = this.costHigh - costLow;
		}
	}
    
    public void cost(int cost) {
    	setCostLow(cost);
    	setCostHigh(cost);
    }
}
