package com.digifreneur.foodaway.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = {"email"}) })
@JsonIgnoreProperties(value = {"created_at", "updated_at"}, 
        allowGetters = true)
public class Users implements Serializable {

    private static final long serialVersionUID = 5081877L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "First name is required")
    private String firstname;

    @Column(nullable = true)
    private String lastname;

    @Email
    @Column(nullable = false, name = "email", length = 150)
    private String email;

    @Column(nullable = true)
    private Date email_verified_at;

    @NotEmpty(message = "This field is required")
    @Column(nullable = false, length = 100)
	@JsonIgnore
    private String password;

    @Column(nullable = true)
    private String remember_token;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;

    @Column(nullable = true)
    private String auth_token;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private int default_address_id;

    @Column(nullable = true)
    private String delivery_pin;
    
    @Column(nullable = true)
    private int delivery_guy_detail_id;

    private String getFullName() {
        return firstname != null ? firstname.concat(" ").concat(lastname) : "";
    }
}