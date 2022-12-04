package proj;

public class Transaction {

  String prodName;
	String transDate; 
	int transQuan;
  String transType;

	Transaction(String prodName, String transDate, int transQuan, String transType) {
		this.prodName = prodName;
		this.transDate = transDate;
		this.transQuan = transQuan;
		this.transType = transType;
	}

	//generated the getters and setter again for the class attributes
	public String getName() {
		return prodName;
	}


	public void setName(String prodName) {
		this.prodName = prodName;
	}


	public String getDate() {
		return transDate;
	}

	public void setDate(String transDate) {
		this.transDate = transDate;
	}

	public int getQuant() {
		return transQuan;
	}
	public void setQuant(int transQuan) {
		this.transQuan = transQuan;
	}
	public String getType() {
		return transType;
	}
	public void setType(String transType) {
		this.transType = transType;
	}
	

	//Modified toString method
	public String toString() {
		return getName() + ", " + getDate()+", "+getQuant()+", "+getType();
	}
}
