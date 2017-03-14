package model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Customer {

	private Integer id;
	private String fName;

	public Customer(Integer id, String fName) {
		this.id = id;
		this.fName = fName;
	}
}
