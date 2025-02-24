
package acme.entities.airline;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.entities.airport.Airport;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AirlineAirport extends AbstractEntity {

	// Serialization -----------------------------------------
	private static final long	serialVersionUID	= 1L;

	// Relations ----------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline				airline;
	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airport				airport;
}
