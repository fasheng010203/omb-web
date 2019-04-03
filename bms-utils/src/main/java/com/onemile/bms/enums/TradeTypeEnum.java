package com.onemile.bms.enums;

/**
 * 表的code号前缀
 * @author chenhao
 *
 */
public enum TradeTypeEnum {


	/**
	 * 1、发料审核、2、发料反审核 3、收料、4、收料反审核 5、调出 6、调出反审核 7、调入 8、调入反审核
	 * 9、暂存 10、暂存反审核 11、提暂存 12、提暂存反审核  13、采购     -13、采购反审核       14、销售     -14、销售反审核     15、加工改制 16、加工改制反审核
	 *
	 */
	STOCK_SEND(1),
	ANTI_STOCK_SEND(2),
	STOCK_RECEIPT(3),
	ANTI_STOCK_RECEIPT(4),
	STOCK_TRANSFER_OUT(5),
	ANTI_STOCK_TRANSFER_OUT(6),
	STOCK_TRANSFER_IN(7),
	ANTI_STOCK_TRANSFER_IN(8),
	STOCK_TEMPORARY_IN(9),
	ANTI_STOCK_TEMPORARY_IN(10),
	STOCK_TEMPORARY_OUT(11),
	ANTI_STOCK_TEMPORARY_OUT(12),
	STOCK_PURCHASE(13),
	ANTI_STOCK_PURCHASE(-13),
	STOCK_SALE(14),
	ANTI_STOCK_SALE(-14),
	STOCK_REMODELING(15),
	ANTI_STOCK_REMODELING(16),
	STOCK_COMPENSATE(17),
	ANTI_STOCK_COMPENSATE(18);



	private int type;

	private TradeTypeEnum(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}




	
	
	
	
}
