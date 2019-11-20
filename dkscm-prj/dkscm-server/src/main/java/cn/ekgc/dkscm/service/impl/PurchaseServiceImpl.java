package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.PurchaseDao;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.PurchaseService;

@Service("purchaseService")
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDao purchaseDao;

	public Page<Purchase> getPurchaseListByPage(String statusCode, Page<Purchase> page) 
			throws Exception {
		// 设定分页查询时所带的参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("begin", (page.getPageNum() - 1) * page.getPageSize());
		paramMap.put("size", page.getPageSize());
		paramMap.put("statusCode", statusCode);
		
		List<Purchase> list = purchaseDao.findPurchaseListByPage(paramMap);
		
		// 为了获得总条数，将原有的分页信息从查询的Map集合中移除
		paramMap.remove("begin");
		paramMap.remove("size");
		Long totalSize = (long) purchaseDao.findPurchaseListByPage(paramMap).size();
		
		// 根据总条数计算总页数
		Long totalPage = (totalSize % page.getPageSize() == 0) ? (totalSize / page.getPageSize()) : (totalSize / page.getPageSize()) + 1;
		
		page.setList(list);
		page.setTotalPage(totalPage);
		page.setTotalSize(totalSize);
		return page;
	}
}
