package com.onemile.bms.enums;

/**
 * 购售类型
 * Created by Hardy on 2018-09-12.
 */
public enum GoodsTypeEnum {

	GOODS_OUT(1,"出售"),
	GOODS_IN(2,"求购");

	private int type;
	private String name;

	private GoodsTypeEnum(int type, String name) {
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

		for (GoodsTypeEnum o : GoodsTypeEnum.values()) {
			if(o.type==type){
				return o.name;
			}
		}
		return "";
	}

}
