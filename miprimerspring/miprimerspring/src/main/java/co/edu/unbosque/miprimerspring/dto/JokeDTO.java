package co.edu.unbosque.miprimerspring.dto;

public class JokeDTO {

	private String category;
	private String type;
	private String setup;
	private String delivery;

	public JokeDTO() {
		// TODO Auto-generated constructor stub
	}

	public JokeDTO(String category, String type, String setup, String delivery) {
		super();
		this.category = category;
		this.type = type;
		this.setup = setup;
		this.delivery = delivery;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSetup() {
		return setup;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String deivery) {
		this.delivery = deivery;
	}

	@Override
	public String toString() {
		return "JokeDTO [category=" + category + ", type=" + type + ", setup=" + setup + ", deivery=" + delivery + "]";
	}
	
}
