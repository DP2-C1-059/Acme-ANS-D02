
package acme.entities.review;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.airline.Airline;
import acme.entities.airport.Airport;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review extends AbstractEntity {

	// Serialization -------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				postedAt;

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				subject;

	@Mandatory
	@ValidString
	@Automapped
	private String				text;

	@Optional
	@ValidNumber(min = 0, max = 10, integer = 2, fraction = 1)
	@Automapped
	private double				score;

	@Optional
	@Automapped
	private Boolean				isRecommended;

	// Relations ---------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airport				airport;
}
