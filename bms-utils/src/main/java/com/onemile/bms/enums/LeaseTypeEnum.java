package com.onemile.bms.enums;

/**
 * 租赁类型
 * Created by Hardy on 2018-09-12.
 */
public enum LeaseTypeEnum {

	LEASE_OUT(1,"出租"),
	LEASE_IN(2,"求租");

	private int type;
	private String name;

	private LeaseTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getNameByType(int type){

		for (LeaseTypeEnum o : LeaseTypeEnum.values()) {
			if(o.type==type){
				return o.name;
			}
		}
		return "";
	}

}
