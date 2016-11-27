package com.example.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemoForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3570891756024535003L;

	private Integer id;
	private String name;
	private String memo;
	private Timestamp createAt;
	private Timestamp updateAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	
}
