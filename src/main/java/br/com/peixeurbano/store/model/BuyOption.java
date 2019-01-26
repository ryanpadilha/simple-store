package br.com.peixeurbano.store.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * BuyOptions Model
 * 
 * @author ryanpadilha
 * @version 0.1
 */
@Document(collection = "buy_option")
public class BuyOption implements Serializable {

	private static final long serialVersionUID = -2250087300258116275L;

	@Id
	private ObjectId id;

	@NotNull
	private String title;

	@NotNull
	private Double normalPrice;

	@NotNull
	private Double salePrice;

	@NotNull
	private Double percentageDiscount;

	@NotNull
	private Long QuantityCupom;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private Date startDate;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private Date endDate;

	@JsonSerialize(using = ToStringSerializer.class)
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(Double normalPrice) {
		this.normalPrice = normalPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(Double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	public Long getQuantityCupom() {
		return QuantityCupom;
	}

	public void setQuantityCupom(Long quantityCupom) {
		QuantityCupom = quantityCupom;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		BuyOption other = (BuyOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BuyOption [title=" + title + ", normalPrice=" + normalPrice + ", salePrice=" + salePrice
				+ ", percentageDiscount=" + percentageDiscount + ", QuantityCupom=" + QuantityCupom + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

}
