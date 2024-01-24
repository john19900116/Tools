package _Tools.parser.fomsorder;

import java.util.Properties;

public class FomsOrderTTFIX {
	private final String reqMesg;
	public String funCode;
	public String date;

	public String time;

	// 來源代碼 SOURCE X(5) 來源碼X(1):Web代碼X(3)
	public String source;
	// 上手下單帳號 FFUT_ACCOUNT X(20)
	public String ffut_account;
	// 下單類別 ACT X(1) C:刪單,M:改單
	public String act;
	// 網路單號 F_OD_SEQ X(20) 交易日期+網路序號
	public String f_od_seq;
	// 原始單來源別 ORG_SOURCE X(5) 格式:原始來源碼X(1):原始Web代碼X(3)
	public String org_source;
	// 原始單網路單號 ORG_OD_SEQ X(20)
	public String org_od_seq;
	// 分公司代碼 BRANCH_ID X(7)
	public String branch_id;
	// 客戶帳號 CUST_ID X(10)
	public String cust_id;
	// 營業員代碼 AGENT_ID X(6)
	public String agent_id;
	// 交易所代號 EXCHANGE X(8)
	public String exchange;
	// 上手委託書號 ORDNO X(20)
	public String ordno;
	// 商品代碼 FTR_ID X(10)
	public String ftr_id;
	// 履約年月 FTR_MTH X(6) yyyyMM
	public String ftr_mth;
	// 履約價 STRIKE_PRICE 9(16) 履約價*1000000
	public String strike_price;
	// CP CALLPUT X(1) F:期貨, C:Call, P:Put
	public String callput;
	// 買賣別 BUYSELL X(1) B:買, S:賣
	public String buysell;
	// 價格旗標 PRICE_FLAG X(1) 0:限價,1:市價,5:停損價,6:停損限價
	public String price_flag;
	// 當沖 DAY_TRADE X(1) Y/N
	public String daytrade;
	// 新平倉碼 OPEN_CLOSE X(1) O:新倉,C:平倉,A:自動
	public String open_close;
	// 委託類別 OD_TYPE X(1) R:ROD ,I:IOC,F:FOK
	public String od_type;
	// 委託價格 OD_PRICE 9(16) 委託價格*1000000
	public String od_price;
	// 停損價格 STOP_PRICE 9(16) 停損價格*1000000
	public String stop_price;
	// 委託口數 OD_QTY 9(4)
	public String od_qty;
	// 改量後口數 CANCELTO_QTY 9(4)
	public String cancelto_qty;
	// 商品代碼2 FTR_ID2 X(10) 第二隻腳
	public String ftr_id2;
	// 履約年月2 FTR_MTH2 X(6) yyyyMM
	public String ftr_mth2;
	// 履約價2 STRIKE_PRICE2 9(16) 履約價*1000000
	public String strike_price2;
	// CP2 CALLPUT2 X(1) F:期貨, C:Call, P:Put
	public String callput2;
	// 買賣別2 BUYSELL2 X(1) B:買, S:賣
	public String buysell2;
	// 連結分公司代碼 EURBRANCH_ID X(7)
	public String eurbranch_id;
	// 連結客戶帳號 EURCUST_ID X(7) ★ ★
	public String eurcust_id;

	public FomsOrderTTFIX(String reqMesg) {
		this.reqMesg = reqMesg;

		parser();

	}

	private void parser() {
		try {
			int pos = 0;
			this.funCode = this.reqMesg.substring(pos, pos += 4);
			this.date = this.reqMesg.substring(pos, pos += 8);
			this.time = this.reqMesg.substring(pos, pos += 6);
			this.source = this.reqMesg.substring(pos, pos += 5);
			this.ffut_account = this.reqMesg.substring(pos, pos += 20);
			this.act = this.reqMesg.substring(pos, pos += 1);
			this.f_od_seq = this.reqMesg.substring(pos, pos += 20);
			this.org_source = this.reqMesg.substring(pos, pos += 5);
			this.org_od_seq = this.reqMesg.substring(pos, pos += 20);
			this.branch_id = this.reqMesg.substring(pos, pos += 7);
			this.cust_id = this.reqMesg.substring(pos, pos += 10);
			this.agent_id = this.reqMesg.substring(pos, pos += 6);
			this.exchange = this.reqMesg.substring(pos, pos += 8);
			this.ordno = this.reqMesg.substring(pos, pos += 20);
			this.ftr_id = this.reqMesg.substring(pos, pos += 10);
			this.ftr_mth = this.reqMesg.substring(pos, pos += 6);
			this.strike_price = this.reqMesg.substring(pos, pos += 16);
			this.callput = this.reqMesg.substring(pos, pos += 1);
			this.buysell = this.reqMesg.substring(pos, pos += 1);
			this.price_flag = this.reqMesg.substring(pos, pos += 1);
			this.daytrade = this.reqMesg.substring(pos, pos += 1);
			this.open_close = this.reqMesg.substring(pos, pos += 1);
			this.od_type = this.reqMesg.substring(pos, pos += 1);
			this.od_price = this.reqMesg.substring(pos, pos += 16);
			this.stop_price = this.reqMesg.substring(pos, pos += 16);
			this.od_qty = this.reqMesg.substring(pos, pos += 4);
			this.cancelto_qty = this.reqMesg.substring(pos, pos += 4);
			this.ftr_id2 = this.reqMesg.substring(pos, pos += 10);
			this.ftr_mth2 = this.reqMesg.substring(pos, pos += 6);
			this.strike_price2 = this.reqMesg.substring(pos, pos += 16);
			this.callput2 = this.reqMesg.substring(pos, pos += 1);
			this.buysell2 = this.reqMesg.substring(pos, pos += 1);
			this.eurbranch_id = this.reqMesg.substring(pos, pos += 7);
			this.eurcust_id = this.reqMesg.substring(pos, pos += 7);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FomsOrderTTFIX [funCode=");
		builder.append(funCode);
		builder.append(", date=");
		builder.append(date);
		builder.append(", time=");
		builder.append(time);
		builder.append(", source=");
		builder.append(source);
		builder.append(", ffut_account=");
		builder.append(ffut_account);
		builder.append(", act=");
		builder.append(act);
		builder.append(", f_od_seq=");
		builder.append(f_od_seq);
		builder.append(", org_source=");
		builder.append(org_source);
		builder.append(", org_od_seq=");
		builder.append(org_od_seq);
		builder.append(", branch_id=");
		builder.append(branch_id);
		builder.append(", cust_id=");
		builder.append(cust_id);
		builder.append(", agent_id=");
		builder.append(agent_id);
		builder.append(", exchange=");
		builder.append(exchange);
		builder.append(", ordno=");
		builder.append(ordno);
		builder.append(", ftr_id=");
		builder.append(ftr_id);
		builder.append(", ftr_mth=");
		builder.append(ftr_mth);
		builder.append(", strike_price=");
		builder.append(strike_price);
		builder.append(", callput=");
		builder.append(callput);
		builder.append(", buysell=");
		builder.append(buysell);
		builder.append(", price_flag=");
		builder.append(price_flag);
		builder.append(", daytrade=");
		builder.append(daytrade);
		builder.append(", open_close=");
		builder.append(open_close);
		builder.append(", od_type=");
		builder.append(od_type);
		builder.append(", od_price=");
		builder.append(od_price);
		builder.append(", stop_price=");
		builder.append(stop_price);
		builder.append(", od_qty=");
		builder.append(od_qty);
		builder.append(", cancelto_qty=");
		builder.append(cancelto_qty);
		builder.append(", ftr_id2=");
		builder.append(ftr_id2);
		builder.append(", ftr_mth2=");
		builder.append(ftr_mth2);
		builder.append(", strike_price2=");
		builder.append(strike_price2);
		builder.append(", callput2=");
		builder.append(callput2);
		builder.append(", buysell2=");
		builder.append(buysell2);
		builder.append(", eurbranch_id=");
		builder.append(eurbranch_id);
		builder.append(", eurcust_id=");
		builder.append(eurcust_id);
		builder.append("]");
		return builder.toString();
	}

}
