package com.example.board.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseTimeEntity {

	@Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createDate;

	@Column(name = "update_date")
	private Timestamp updateDate;

	@PreUpdate
	public void preUpdate() {
		this.updateDate = new Timestamp(System.currentTimeMillis());
	}
}
