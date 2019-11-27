package cn.ekgc.dkscm.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.PurchaseDao;
import cn.ekgc.dkscm.dao.UserDao;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.entity.Status;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.PurchaseService;
import cn.ekgc.dkscm.util.ConstantUtil;

/**
 * <b>采购模块业务层接口实现类</b>
 * @author Arthur
 * @version 2.0.0 2019-11-19
 * @since 2019-11-19
 */
@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	@Resource(name = "purchaseDao")
	private PurchaseDao purchaseDao;

	/**
	 * <b>根据采购状态分页查询采购分页对象</b>
	 * @param page
	 * @param statusCode
	 * @return
	 * @throws Exception
	 */
	public Page<Purchase> getPurchasePageByStatusCode(String statusCode, Page<Purchase> page) throws Exception{
		// 绑定Map查询条件
		Map<String, Object> paramMap = new HashMap<String, Object>();
		// 绑定分页信息
		paramMap.put("begin", page.getBegin());
		paramMap.put("size", page.getSize());
		// 绑定采购状态
		paramMap.put("statusCode", statusCode);
		
		// 进行分页查询，获得列表
		List<Purchase> list = purchaseDao.findPurchaseListByQuery(paramMap);
		// 为了能够获得相应的总条数，需要去掉分页的信息
		paramMap.remove("begin");
		paramMap.remove("size");
		Long totalSize = (long)purchaseDao.findPurchaseListByQuery(paramMap).size();
		
		// 分别设定分页信息
		page.setList(list);
		page.setTotalSize(totalSize);
		page.setTotalPage();
		return page;
	}

	@Override
	/**
	 * <b>保存采购信息</b>
	 * @param purchase
	 * @param applicant
	 * @return
	 * @throws Exception
	 */
	public boolean savePurchase(Purchase purchase, User applicant) throws Exception {
		// 生成采购订单编号，采用规则，DK+当前时间的毫秒数
		purchase.setPurchaseNo("DK" + System.currentTimeMillis());
		// 设定采购人
		purchase.setApplicant(applicant);
		// 设定采购申请时间
		purchase.setApplyTime(new Date());
		// 设定状态为已申请，未审批
		Status status = new Status();
		status.setStatusCode(ConstantUtil.STATUS_APPLY);
		purchase.setStatus(status);
		
		// 使用数据持久层进行保存
		try {
			purchaseDao.savePurchase(purchase);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePurchase(Purchase purchase) throws Exception {
		try {
			purchaseDao.updatePurchase(purchase);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public Purchase findPurchaseById(Long purchaseId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("purchaseId", purchaseId);
			List<Purchase> list = purchaseDao.findPurchaseListByQuery(paramMap);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
		return null;
	}
}