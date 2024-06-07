package com.manage.platform.entity;


import java.io.Serializable;
import java.sql.Date;

public class CardInssuerDetail implements Serializable{


	/**
	 * 
	 */
	
	
	
	
	 //[id=�ֻ���, reservdate=null, nettype=null, refer=2013-05-10 00:00:00.000, revered=18792421674, 

	   // city=����, people_id=�����, add_card=15691935993, username=�������������������, add2=��ɯɯ, 

	   // tel=2, card_id=null, post=null]
	
	
	
	
	
	//source������Դ
	//cardid������
	//craddate��������
	//realted��ϵ�绰
	//areacode����
	//username�û���
	//tel�������
	//useradd���͵�ַ
	//operman������
	//duration������ʱ��
	
	//source������Դ
	//cardid������
	//craddate��������
	//realted��ϵ�绰
	//areacode����
	//username�û���
	//tel�������
	//useradd���͵�ַ
	//operman������
	//duration������ʱ��
	
	
//	getId()������Դ
//	getReservdate()������
//	getRefer()��������
//	getRevered()��ϵ�绰
//	getCity()����
//	getPeople_id()�û���
//	getAdd_card()�������
//	getUsername()���͵�ַ
//	getAdd2()������
//	getTel()������ʱ��
	
	
	
	
	private static final long serialVersionUID = 1526705009706221747L;
	
	
	//新增
	
	private String areacode;
	private String nettype;
	private String craddate;
	private String cardid;
	private String realted;
	private String username;
	private String useradd;
	private String tel;
	private String operman;
	private String duration;
	private String billDate;
	private String expDate;
	private String refer;
	private String type;
	
	
	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getCraddate() {
		return craddate;
	}

	public void setCraddate(String craddate) {
		this.craddate = craddate;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getRealted() {
		return realted;
	}

	public void setRealted(String realted) {
		this.realted = realted;
	}

	public String getUseradd() {
		return useradd;
	}

	public void setUseradd(String useradd) {
		this.useradd = useradd;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	
	
	
	
	
	
	
	
	private String id;//�ֻ���
	private Date reservdate;//null

	private String revered;//18792421674
	private String city;//����
	private String people_id;//�����
	private String add_card;//15691935993

	private String add2;//��ɯɯ

	private String card_id;//null
	private String post;//null

	private String bill_date;
	private String exp_date;
	private String page;

	/** default constructor */
	public CardInssuerDetail() {
	}

	/** minimal constructor */
	
//	public CardInssuerDetail(String id,Date reservdate, String nettype, String refer,
//			String revered, String city, String people_id, String add_card,
//			String username, String add2, String tel, String card_id,
//			String post) {
//		this.id=id;
//		this.reservdate = reservdate;
//		this.nettype = nettype;
//		this.refer = refer;
//		this.revered = revered;
//		this.city = city;
//		this.people_id = people_id;
//		this.add_card = add_card;
//		this.username = username;
//		this.add2 = add2;
//		this.tel = tel;
//		this.card_id = card_id;
//		this.post = post;
//	}
//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "CardInssuerDetail " +
//				"[id=" + id + ", reservdate="
//				+ reservdate + ", nettype=" + nettype
//				+ ", refer=" + refer + ", revered="
//				+ revered + ", city=" + city
//				+ ", people_id=" + people_id + ", add_card="
//				+ add_card + ", username=" + username + ", add2="
//				+ add2 + ", tel=" + tel 
//				+ ", card_id=" + card_id + ", post=" + post
//				+ "]";
//	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getReservdate() {
		return reservdate;
	}

	public void setReservdate(Date reservdate) {
		this.reservdate = reservdate;
	}

	public String getNettype() {
		return nettype;
	}

	public void setNettype(String nettype) {
		this.nettype = nettype;
	}

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public String getRevered() {
		return revered;
	}

	public void setRevered(String revered) {
		this.revered = revered;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPeople_id() {
		return people_id;
	}

	public void setPeople_id(String people_id) {
		this.people_id = people_id;
	}

	public String getAdd_card() {
		return add_card;
	}

	public void setAdd_card(String add_card) {
		this.add_card = add_card;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getOperman() {
		return operman;
	}

	public void setOperman(String operman) {
		this.operman = operman;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
