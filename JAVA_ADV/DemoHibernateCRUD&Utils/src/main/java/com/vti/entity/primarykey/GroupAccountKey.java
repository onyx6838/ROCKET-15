package com.vti.entity.primarykey;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class GroupAccountKey implements Serializable {

	@Column(name = "GroupID")
	private short groupId;

	@Column(name = "AccountID")
	private short accountId;

}
