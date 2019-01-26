package br.com.peixeurbano.store.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import br.com.peixeurbano.store.commons.DealType;

/**
 * Deal Model
 * 
 * @author ryanpadilha
 * @version 0.1
 */
@Document(collection = "deal")
public class Deal implements Serializable {

	private static final long serialVersionUID = 2810170700384825047L;

	@Id
	private ObjectId id;

	@NotNull
	private String title;

	@NotNull
	private String text;

	@NotNull
	@JsonIgnore
	private Date createDate = new Date();

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // yyyy-MM-dd@HH:mm:ss.SSSZ
//	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private Date publishDate;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private Date endDate;

	@NotNull
	@Indexed(unique = true)
	private String url;

	@NotNull
	private Long totalSold = 0L;

	@NotNull
	private DealType type;

//	@DBRef
	private Collection<BuyOption> buyOptions;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(Long totalSold) {
		this.totalSold = totalSold;
	}

	public DealType getType() {
		return type;
	}

	public void setType(DealType type) {
		this.type = type;
	}

	public Collection<BuyOption> getBuyOptions() {
		return buyOptions;
	}

	public void setBuyOptions(Collection<BuyOption> buyOptions) {
		this.buyOptions = buyOptions;
	}

	public boolean addBuyOption(BuyOption element) {
		if (this.buyOptions == null) {
			this.buyOptions = new ArrayList<>(); // CollectionUtils.emptyCollection();
		}

		return this.buyOptions.add(element);
	}

	public boolean removeBuyOption(BuyOption element) {
		if (this.buyOptions == null) {
			this.buyOptions = new ArrayList<>(); // CollectionUtils.emptyCollection();
		}

		return this.buyOptions.remove(element);
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
		Deal other = (Deal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Deal [title=" + title + ", text=" + text + ", createDate=" + createDate + ", publishDate=" + publishDate
				+ ", endDate=" + endDate + ", url=" + url + ", totalSold=" + totalSold + ", type=" + type + "]";
	}

}