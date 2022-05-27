package com.microservicios.app.usuarios.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "name")
	private String name;

	@NotEmpty
	@Column(name = "user_name", unique = true)
	private String userName;

	@NotEmpty
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@NotEmpty
	@Column(name = "phone")
	private String phone;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	public User() {

	}

	public User(String name, String userName, String email, String phone) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
	}

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	@Override
	public int hashCode() {
		return Objects.hash(createAt, email, id, name, phone, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(createAt, other.createAt) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(userName, other.userName);
	}
}