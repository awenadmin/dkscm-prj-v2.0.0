package cn.ekgc.dkscm.util;

import java.util.Properties;

public class ConstantUtil {
	private static Properties props = new Properties();
	
	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("config/props/dkscm.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>分页常量：当前页码</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));
	
	/**
	 * <b>分页常量：每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));
	
	/**
	 * <b>系统状态：启用状态</b>
	 */
	public static final String STATUS_ENABLE = props.getProperty("status.enable");
	
	/**
	 * <b>系统状态：禁用状态</b>
	 */
	public static final String STATUS_DISABLE = props.getProperty("status.disable");
	
	/**
	 * <b>采购流程：已申请，未审批</b>
	 */
	public static final String STATUS_APPLY = props.getProperty("status.apply");
	
	/**
	 * <b>采购流程：已审批，未购买</b>
	 */
	public static final String STATUS_REVIEW = props.getProperty("status.review");
	
	/**
	 * <b>采购流程：已购买，为入库审批</b>
	 */
	public static final String STATUS_PURCHASE = props.getProperty("status.purchase");
	
	/**
	 * <b>采购流程：已入库审批，未入库</b>
	 */
	public static final String STATUS_STORE_REVIEW = props.getProperty("status.store.review");
	
	/**
	 * <b>采购流程：已入库，未领取</b>
	 */
	public static final String STATUS_STORE = props.getProperty("status.store");
	
	/**
	 * <b>采购流程：已领取</b>
	 */
	public static final String STATUS_RECEIVE = props.getProperty("status.receive");
	
	/**
	 * <b>采购流程：申请驳回</b>
	 */
	public static final String STATUS_REVIEW_BACK= props.getProperty("status.review.back");
	
	/**
	 * <b>采购流程：入库申请驳回</b>
	 */
	public static final String STATUS_STORE_BACK= props.getProperty("status.store.back");
	
	/**
	 * <b>采购流程：申请撤回</b>
	 */
	public static final String STATUS_APPLY_BACK= props.getProperty("status.apply.back");
}