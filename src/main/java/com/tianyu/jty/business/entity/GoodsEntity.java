package com.tianyu.jty.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mini_goods")
public class GoodsEntity{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="goods_imgs")
	private String goodsImgs;
	
	@Column(name="goods_index_img")
	private String goodsIndexImg;
	
	@Column(name="goods_Introduce")
	private String goodsIntroduce;
	
	@Column(name="goods_introduce_imgs")
	private String goodsIntroduceImgs;
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="goods_price")
	private String goodsPrice;
	
	@Column(name="goods_real_imgs")
	private String goodsRealImgs;
	
	@Column(name="goods_second_type_id")
	private String goodsSecondTypeId;
	
	@Column(name="goods_spec")
	private String goodsSpec;
	
	@Column(name="goods_unit")
	private String goodsUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsImgs() {
		return goodsImgs;
	}

	public void setGoodsImgs(String goodsImgs) {
		this.goodsImgs = goodsImgs;
	}

	public String getGoodsIndexImg() {
		return goodsIndexImg;
	}

	public void setGoodsIndexImg(String goodsIndexImg) {
		this.goodsIndexImg = goodsIndexImg;
	}

	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}

	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}

	public String getGoodsIntroduceImgs() {
		return goodsIntroduceImgs;
	}

	public void setGoodsIntroduceImgs(String goodsIntroduceImgs) {
		this.goodsIntroduceImgs = goodsIntroduceImgs;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsRealImgs() {
		return goodsRealImgs;
	}

	public void setGoodsRealImgs(String goodsRealImgs) {
		this.goodsRealImgs = goodsRealImgs;
	}

	public String getGoodsSecondTypeId() {
		return goodsSecondTypeId;
	}

	public void setGoodsSecondTypeId(String goodsSecondTypeId) {
		this.goodsSecondTypeId = goodsSecondTypeId;
	}

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

}
