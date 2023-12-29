package com.gpg.swarna.kalakar.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	private String customerName;

	private String custVillageName;

	private String referenceName;

	private Double amountLend;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfIssue;

	private Double rateOfInterest;

	@ElementCollection
	@CollectionTable(name = "customer_items", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "customer_value")
	private List<String> itemDetails;
	
	private Integer duration;

	@PrePersist
	protected void onCreate() {
		if (dateOfIssue == null) {
			dateOfIssue = new Date(); // Set the default value to the current date and time
		}
	}
}
