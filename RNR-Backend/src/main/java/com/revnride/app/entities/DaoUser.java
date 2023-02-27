package com.revnride.app.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@Builder
@Table(name = "users")
public class DaoUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	/** id */
	private Long id;

	@NotBlank
	@Size(max = 20)
	/** username */
	private String username;

	@NotBlank
	@Size(max = 50)
//	@Email
	/** email */
	private String email;

	@NotBlank
	@Size(max = 120)
	/** password */
	private String password;

	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
	/** reservations */
	private List<Reservation> reservations = new ArrayList<>();

	/** Constructor */
	/**
	 * @param username Name of User
	 * @param email    Email of User
	 * @param password Password of User
	 * @param roles    Role of User
	 */
	public DaoUser(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) /* @Email */ String email,
			@NotBlank @Size(max = 120) String password, String role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	/**
	 * @param reservations setReservations
	 */
	public void setReservations(Reservation reservations) {
		this.reservations.add(reservations);
	}

	/**
	 * compatre Object User
	 */

	public boolean compareTo(Object obj) {
		if (obj instanceof DaoUser) {
			DaoUser user = (DaoUser) obj;
			return id.equals(user.id) && username.equals(user.username) && email.equals(user.email)
					&& password.equals(user.password) && (role.equals(user.role));
		}
		return false;
	}


}
