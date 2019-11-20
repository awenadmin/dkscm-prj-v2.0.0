package cn.ekgc.dkscm.service;

import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;

public interface PurchaseService {
	Page<Purchase> getPurchaseListByPage(String statusCode, Page<Purchase> page) throws Exception;
}
