package ru.alina.trucking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="applications")
public class Application {

    @Id
	@GeneratedValue
    private Long id;
	
    @ManyToOne
    private User owner;

    private Date updatedAt;

    private Date acceptedAt;

    private Date completedAt;
    
    private Double volume;

    private Double weight;
    
    private Date createdAt; //время создания заявки
    
    @Enumerated(EnumType.STRING)
    private Status status;

    private String addressFrom;

    private String addressTo;

    private String userName;

    private String  phone;
    
    private String comment;
    
    private Application() {}

	public Application(User owner, String addressFrom, String addressTo, Double weight,  Double volume, String comment, String phone, String userName ) {
		this.owner = owner;
		this.addressFrom = addressFrom;
        this.addressTo = addressTo;
		this.volume = volume;
        this.weight = weight;
		this.createdAt = new Date();
		this.status = Status.NEW;
		this.phone = phone;
		this.userName = userName;
		this.comment = comment;

	}
}
