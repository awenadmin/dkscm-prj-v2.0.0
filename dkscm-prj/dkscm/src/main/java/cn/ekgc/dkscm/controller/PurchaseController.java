package cn.ekgc.dkscm.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.entity.Status;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.PurchaseService;
import cn.ekgc.dkscm.util.ConstantUtil;

/**
 * <b>订单模块控制层</b>
 * @author Arthur
 * @version 1.0.0 2019-11-18
 * @since 2019-11-18
 */
@Controller("purchaseController")
@RequestMapping("/purchase")
public class PurchaseController extends BaseController {
	@Resource(name = "purchaseService")
	private PurchaseService purchaseService;
	
	@RequestMapping(value = "/{statusCode}/index")
	public String purchaseIndex(@PathVariable("statusCode") String statusCode, ModelMap map) 
			throws Exception {
		map.put("statusCode", statusCode);
		// 因为使用了异步请求，因此对于该处理，仅仅是转发到列表页面
		if (ConstantUtil.STATUS_APPLY.equals(statusCode)) {
			// 已申请，未审批
			return "purchase/purchase_apply_index";
		} else if (ConstantUtil.STATUS_REVIEW.equals(statusCode)) {
			// 已审批，未采购
			return "purchase/purchase_review_index";
		} else if (ConstantUtil.STATUS_PURCHASE.equals(statusCode)) {
			// 已采购，未审批入库
			return "purchase/purchase_purchase_index";
		} else if (ConstantUtil.STATUS_STORE_REVIEW.equals(statusCode)) {
			// 已审批入库，未入库
			return "purchase/purchase_store_review_index";
		} else if (ConstantUtil.STATUS_STORE.equals(statusCode)) {
			// 已入库，未领取
			return "purchase/purchase_store_index";
		} else if (ConstantUtil.STATUS_RECEIVE.equals(statusCode)) {
			// 已领取
			return "purchase/purchase_receive_index";
		} else if (ConstantUtil.STATUS_REVIEW_BACK.equals(statusCode)) {
			// 申请驳回
			return "purchase/purchase_review_back_index";
		} else if (ConstantUtil.STATUS_STORE_BACK.equals(statusCode)) {
			// 入库申请驳回
			return "purchase/purchase_store_back_index";
		} else if (ConstantUtil.STATUS_APPLY_BACK.equals(statusCode)) {
			// 申请撤回
			return "purchase/purchase_store_back_index";
		}
		return "";
	}
	
	@RequestMapping(value = "/{statusCode}/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<Purchase> getPurchaseListByPage(@PathVariable("statusCode") String statusCode, 
			Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 封装Page对象
		Page<Purchase> page = new Page<Purchase>(pageNum, pageSize, draw);
		
		// 使用业务层进行查询
		page = purchaseService.getPurchasePageByStatusCode(statusCode, page);
		return page;
	}
	/**
	 * <b>转发物资采购申请页面</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.GET)
	public String forwardPurchaseApplyPage() throws Exception {
		// 因为在加载申请页面的时候，是不需要相应的数据，直接转发即可
		return "purchase/purchase_apply";
	}
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	@ResponseBody
	public boolean savePurchaseApply(Purchase purchase) throws Exception {
		// 获得当前登录用户，作为申请人信息
		User user = (User) session.getAttribute("user");
		// 对于校验来说，前端校验有可能失效，因此无论有无前端校验，都必须有后端校验
		// 校验通过后，使用业务层进行保存
		return purchaseService.savePurchase(purchase, user);
	}
	
	@RequestMapping(value="/review/{purchaseId}",method=RequestMethod.GET)
	public String forwardPurchasePage(@PathVariable("purchaseId")Long purchaseId, ModelMap map) throws Exception {
		//再打开审批页面的时候，同时也需要传递此时采购的Id
		map.put("purchaseId",purchaseId);
		return "purchase/purchase_review";
	}
	@RequestMapping(value = "/review/{purchaseId}", method = RequestMethod.POST)
	@ResponseBody
	public boolean reviewPurchase(@PathVariable("purchaseId")Long purchaseId,String reviewRemark,String statusCode) throws Exception{
		Status status  = new Status();
		status.setStatusCode(statusCode);
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);
		purchase.setReviewRemark(reviewRemark);
		purchase.setStatus(status);
		User reviewer = (User)session.getAttribute("user");
		purchase.setReviewer(reviewer);
		purchase.setReceiveTime(new Date());
		return purchaseService.updatePurchase(purchase);
	}
	@RequestMapping(value="/buy/{purchaseId}",method=RequestMethod.GET)
	public String forwordPurchasePage(@PathVariable("purchaseId")Long purchaseId, ModelMap map) throws Exception {
		map.put("purchaseId", purchaseId);
		return "purchase/purchase_buy";
	}
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	@ResponseBody
	public boolean buyPurchase(Purchase purchase) throws Exception {
		// 获得当前登录用户
		User purchaser = (User) session.getAttribute("user");
		Status status = new Status();
		status.setStatusCode(ConstantUtil.STATUS_PURCHASE);
		purchase.setStatus(status);
		purchase.setPurchaser(purchaser);
		purchase.setPurchaseTime(new Date());
		return purchaseService.updatePurchase(purchase);
	}
	@RequestMapping(value = "/store_review/{purchaseId}", method = RequestMethod.GET)
	public String forwardStoreReviewPage(@PathVariable("purchaseId")Integer purchaseId,ModelMap map) throws Exception {
		// 因为在加载申请页面的时候，是不需要相应的数据，直接转发即可
		map.put("purchaseId", purchaseId);
		return "purchase/purchase_store_review";
	}
	/**
	 * <b>进行入库审批</b>
	 * @param purchaseId
	 * @param storeReviewRemark
	 * @param statusCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/store_review/{purchaseId}", method = RequestMethod.POST)
	@ResponseBody
	public boolean store_reviewPurchase(@PathVariable("purchaseId")Long purchaseId, String storeReviewRemark, String statusCode) 
			throws Exception {
		// 通过状态编码封装状态对象
		Status status = new Status();
		status.setStatusCode(statusCode);
		// 创建Purchase对象
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);
		purchase.setStoreReviewRemark(storeReviewRemark);
		purchase.setStatus(status);
		// 获得当前登录用户
		User storeReviewer = (User) session.getAttribute("user");
		purchase.setStoreReviewer(storeReviewer);
		// 审批时间
		purchase.setStoreReviewTime(new Date());
		return purchaseService.updatePurchase(purchase);
	}
	/**
	 * <b>转发物资入库页面</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/store/{purchaseId}", method = RequestMethod.GET)
	public String forwardStorePage(@PathVariable("purchaseId")Integer purchaseId,ModelMap map) throws Exception {
		// 因为在加载申请页面的时候，是不需要相应的数据，直接转发即可
		map.put("purchaseId", purchaseId);
		return "purchase/purchase_store";
	}
	/**
	 * <b>进行入库</b>
	 * @param purchaseId
	 * @param storeRemark
	 * @param statusCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/store/{purchaseId}", method = RequestMethod.POST)
	@ResponseBody
	public boolean storePurchase(@PathVariable("purchaseId")Long purchaseId, String storeRemark, String statusCode) 
			throws Exception {
		// 通过状态编码封装状态对象
		Status status = new Status();
		status.setStatusCode(statusCode);
		// 创建Purchase对象
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);
		purchase.setStoreRemark(storeRemark);
		purchase.setStatus(status);
		// 获得当前登录用户
		User storeman = (User) session.getAttribute("user");
		purchase.setStoreman(storeman);
		// 审批时间
		purchase.setStoreTime(new Date());
		return purchaseService.updatePurchase(purchase);
	}
	/**
	 * <b>转发物资入库页面</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/receive/{purchaseId}", method = RequestMethod.GET)
	public String forwardReceivePage(@PathVariable("purchaseId")Integer purchaseId,ModelMap map) throws Exception {
		// 因为在加载申请页面的时候，是不需要相应的数据，直接转发即可
		map.put("purchaseId", purchaseId);
		return "purchase/purchase_receive";
	}
	/**
	 * <b>进行入库</b>
	 * @param purchaseId
	 * @param receiveRemark
	 * @param statusCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/receive/{purchaseId}", method = RequestMethod.POST)
	@ResponseBody
	public boolean receivePurchase(@PathVariable("purchaseId")Long purchaseId, String receiveRemark, String statusCode) 
			throws Exception {
		// 通过状态编码封装状态对象
		Status status = new Status();
		status.setStatusCode(statusCode);
		// 创建Purchase对象
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);
		purchase.setReceiveRemark(receiveRemark);
		purchase.setStatus(status);
		// 获得当前登录用户
		User receiver = (User) session.getAttribute("user");
		purchase.setReceiver(receiver);
		// 审批时间
		purchase.setReceiveTime(new Date());
		return purchaseService.updatePurchase(purchase);
	}
	@RequestMapping(value = "/reviewDetail/{purchaseId}", method = RequestMethod.GET)
	public String forwardStoreReviewPage(@PathVariable("purchaseId")Long purchaseId,ModelMap map) throws Exception {
		// 因为在加载申请页面的时候，是不需要相应的数据，直接转发即可
		Purchase purchase = purchaseService.findPurchaseById(purchaseId);
		map.put("purchase", purchase);
		return "purchase/review_index";
	}
	@RequestMapping(value = "/buyindex/{purchaseId}", method = RequestMethod.GET)
	public String forwardReceivePage(@PathVariable("purchaseId")Long purchaseId,ModelMap map) throws Exception {
		// 因为在加载申请页面的时候，是不需要相应的数据，直接转发即可
		Purchase purchase = purchaseService.findPurchaseById(purchaseId);
		map.put("purchase", purchase);
		return "purchase/buy_receive";
	}
}