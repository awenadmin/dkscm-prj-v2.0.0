package cn.ekgc.dkscm.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>采购实体类</b>
 * @author Arthur
 * @version 2.0.0 2019-11-19
 * @since 2019-11-19
 */
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long purchaseId;
	private String purchaseNo;
	private String goodsName;
	private String goodsBand;
	private String goodsType;
	private Double applyQuantity;
	private String goodsUnit;
	private Double budget;
	private String applyRemark;
	private User applicant;
	private Date applyTime;
	private User reviewer;
	private String reviewRemark;
	private Date reviewTime;
	private User purchaser;
	private String purchaseBand;
	private String purchaseType;
	private Double purchaseQuantity;
	private Double purchaseAmount;
	private String purchaseRemark;
	private Date purchaseTime;
	private User storeReviewer;
	private String storeReviewRemark;
	private Date storeReviewTime;
	private User storeman;
	private String storeRemark;
	private Date storeTime;
	private User receiver;
	private String receiveRemark;
	private Date receiveTime;
	private Status status;
	private Date createTime;
	
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsBand() {
		return goodsBand;
	}
	public void setGoodsBand(String goodsBand) {
		this.goodsBand = goodsBand;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Double getApplyQuantity() {
		return applyQuantity;
	}
	public void setApplyQuantity(Double applyQuantity) {
		this.applyQuantity = applyQuantity;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getApplyRemark() {
		return applyRemark;
	}
	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public User getReviewer() {
		return reviewer;
	}
	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	public String getReviewRemark() {
		return reviewRemark;
	}
	public void setReviewRemark(String reviewRemark) {
		this.reviewRemark = reviewRemark;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	public User getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(User purchaser) {
		this.purchaser = purchaser;
	}
	public String getPurchaseBand() {
		return purchaseBand;
	}
	public void setPurchaseBand(String purchaseBand) {
		this.purchaseBand = purchaseBand;
	}
	public String getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	public Double getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Double purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getPurchaseRemark() {
		return purchaseRemark;
	}
	public void setPurchaseRemark(String purchaseRemark) {
		this.purchaseRemark = purchaseRemark;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public User getStoreReviewer() {
		return storeReviewer;
	}
	public void setStoreReviewer(User storeReviewer) {
		this.storeReviewer = storeReviewer;
	}
	public String getStoreReviewRemark() {
		return storeReviewRemark;
	}
	public void setStoreReviewRemark(String storeReviewRemark) {
		this.storeReviewRemark = storeReviewRemark;
	}
	public Date getStoreReviewTime() {
		return storeReviewTime;
	}
	public void setStoreReviewTime(Date storeReviewTime) {
		this.storeReviewTime = storeReviewTime;
	}
	public User getStoreman() {
		return storeman;
	}
	public void setStoreman(User storeman) {
		this.storeman = storeman;
	}
	public String getStoreRemark() {
		return storeRemark;
	}
	public void setStoreRemark(String storeRemark) {
		this.storeRemark = storeRemark;
	}
	public Date getStoreTime() {
		return storeTime;
	}
	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public String getReceiveRemark() {
		return receiveRemark;
	}
	public void setReceiveRemark(String receiveRemark) {
		this.receiveRemark = receiveRemark;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}