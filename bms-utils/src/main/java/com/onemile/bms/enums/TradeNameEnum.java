package com.onemile.bms.enums;

/**
 * 表的code号前缀
 * @author chenhao
 *
 */
public enum TradeNameEnum {


	/**
	 * 1、发料审核、2、发料反审核 3、收料、4、收料反审核 5、调出 6、调出反审核 7、调入 8、调入反审核
	 * 9、暂存 10、暂存反审核 11、提暂存 12、提暂存反审核  13、采购     -13、采购反审核       14、销售     -14、销售反审核     15、加工改制 16、加工改制反审核
	 *
	 */
	STOCK_SEND(1,"发料"),
	STOCK_RECEIPT(3,"收料"),
	STOCK_TRANSFER_OUT(5,"调出"),

	STOCK_TRANSFER_IN(7,"调入"),

	STOCK_TEMPORARY_IN(9,"暂存"),

	STOCK_TEMPORARY_OUT(11,"提暂存"),

	STOCK_PURCHASE(13,"采购"),

	STOCK_SALE(14,"销售"),

	STOCK_REMODELING(15,"加工改制"),

	STOCK_COMPENSATE(17,"赔偿");




	private int type;
	private String name;

	private TradeNameEnum(int type,String name) {
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
	public static String getTradeName(Integer type) {

		String name="";
		for (TradeNameEnum  value: TradeNameEnum.values()) {

			if(value.getType()==type){
				return value.getName();
			}
		}

		return name;
	}




}
