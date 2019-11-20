package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Status;

/**
 * <b>状态模块数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0 2019-11-13
 * @since 2019-11-13
 */
public interface StatusDao {
	/**
	 * <b>根据查询条件获得状态信息列表</b>
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	List<Status> findStatusListByQuery(Map<String, Object> paramMap) throws Exception;
}
