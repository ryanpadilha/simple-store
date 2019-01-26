package br.com.peixeurbano.store.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * Purchase Model
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@Document(collection = "purchase")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 3732567181486126105L;

	@Id
	private ObjectId id;

	@NotNull
	private ObjectId dealId;

	@NotNull
	private ObjectId buyOptionId;

	@NotNull
	private Long quantity;

	@NotNull
	private Date currentDate = new Date();

	@JsonSerialize(using = ToStringSerializer.class)
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	@JsonSerialize(using = ToStringSerializer.class)
	public ObjectId getDealId() {
		return dealId;
	}

	public void setDealId(ObjectId dealId) {
		this.dealId = dealId;
	}

	@JsonSerialize(using = ToStringSerializer.class)
	public ObjectId getBuyOptionId() {
		return buyOptionId;
	}

	public void setBuyOptionId(ObjectId buyOptionId) {
		this.buyOptionId = buyOptionId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buyOptionId == null) ? 0 : buyOptionId.hashCode());
		result = prime * result + ((dealId == null) ? 0 : dealId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (buyOptionId == null) {
			if (other.buyOptionId != null)
				return false;
		} else if (!buyOptionId.equals(other.buyOptionId))
			return false;
		if (dealId == null) {
			if (other.dealId != null)
				return false;
		} else if (!dealId.equals(other.dealId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", dealId=" + dealId + ", buyOptionId=" + buyOptionId + ", quantity=" + quantity
				+ ", currentDate=" + currentDate + "]";
	}

}
