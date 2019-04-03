package com.onemile.bms.enums;

/**
 * Created by Hardy on 2018-08-06.
 */
public enum SettleTypeEnum {


	SETTLE_LEASE(0,"租赁"),
	SETTLE_TEMPORARY(1,"暂存"),
	SETTLE_TRANS(2,"调拨");

	private int type;
	private String name;

	private SettleTypeEnum(int type,String name) {
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

		for (SettleTypeEnum o : SettleTypeEnum.values()) {
			if(o.type==type){
				return o.name;
			}
		}
		return "";
	}

}
