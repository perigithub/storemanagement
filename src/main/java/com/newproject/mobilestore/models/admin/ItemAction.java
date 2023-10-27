package com.newproject.mobilestore.models.admin;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class ItemAction {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false)
	private Long quantity;

	@JsonIgnore
	@CreatedDate
	private LocalDateTime createdDate;

	@JsonIgnore
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Item item;

	ItemAction() {
		this.price = BigDecimal.ZERO;
		this.quantity = 0L;
	}
}

