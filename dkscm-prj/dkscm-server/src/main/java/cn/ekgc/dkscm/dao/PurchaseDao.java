package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Purchase;

public interface PurchaseDao {
	//根据查询条件获得采购列表

	List<Purchase> findPurchaseListByQuery(Map<String, Object> paramMap) throws Exception;

	void savePurchase(Purchase purchase) throws Exception;

	void updatePurchase(Purchase purchase)throws Exception;

}
