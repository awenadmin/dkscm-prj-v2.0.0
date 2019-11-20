package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Purchase;

public interface PurchaseDao {
	List<Purchase> findPurchaseListByPage(Map<String, Object> paramMap) throws Exception;
}
