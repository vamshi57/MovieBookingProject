package com.vamshi.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Booking {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)	
   private Long bookingId;
   private String moiveName;
   private String chName;
   private Date bookingDate;
   private String personName;
   private Long   contactNumber;
   private String emailId;
   
}
