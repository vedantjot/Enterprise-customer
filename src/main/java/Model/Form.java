package Model;
import javax.persistence.*;

@Entity 
@Table(name="Form")

public class Form {
	
	public Form() {
		super();
	}



	public Form(int iD) {
		super();
		ID = iD;
	}

	

	public Form(String name, String number, String city) {
		super();
		this.name = name;
		this.number = number;
		this.city = city;
	}

	public Form(int iD, String name, String number, String city) {
		super();
		ID = iD;
		this.name = name;
		this.number = number;
		this.city = city;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name ="Id")
	private int ID;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="number")
	private String number;
	
	@Column(name ="city")
	private String city;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	

}
