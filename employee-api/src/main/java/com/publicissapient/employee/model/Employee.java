package com.publicissapient.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude="password")

// @JsonIgnoreProperties("password")

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private long id;

	@Column(name = "USERNAME", length = 255, nullable = false)
	private String username;

	@Column(name = "PASSWORD", length = 255, nullable = false)
	private String password;

	@Column(name = "FIRST_NAME", length = 255, nullable = false)
	private String firstName;

	@Column(name = "MIDDLE_NAME", length = 255, nullable = true)
	private String middleName;

	@Column(name = "LAST_NAME", length = 255, nullable = false)
	private String lastName;

	@Column(name = "EMAIL", length = 255, nullable = false)
	private String email;

	@Column(name = "ADDRESS", length = 255, nullable = false)
	private String address;
}
