package cn.ekgc.dkscm.pojo.vo;

import java.io.Serializable;
import java.util.List;

import cn.ekgc.dkscm.util.ConstantUtil;

/**
 * <b>项目分页视图对象</b>
 * @author Arthur
 * @version 2.0.0 2019-11-19
 * @since 2019-11-19
 */
public class Page<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;						// 当前页码
	private Integer pageSize;						// 每页显示数量
	private Integer draw;							// DataTables组件异步获取数据确认信息
	private Integer begin;							// MySQL分页开始下标
	private Integer size;							// MySQL分页连续查询条数
	private List<E> list;							// 分页列表
	private Long totalSize;							// 总数量
	private Long totalPage;							// 总页数
	
	public Page() {}
	public Page(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
		
		this.begin = (this.pageNum - 1) * this.pageSize;
		this.size = this.pageSize;
	}
	public Page(Integer pageNum, Integer pageSize, Integer draw) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
		
		this.begin = (this.pageNum - 1) * this.pageSize;
		this.size = this.pageSize;
		
		this.draw = draw;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * <b>使用当前总条数和每页显示数量设定总页数</b>
	 */
	public void setTotalPage() {
		this.totalPage = (this.totalSize % this.pageSize == 0) ? (this.totalSize / this.pageSize) 
				: (this.totalSize / this.pageSize) + 1;
	}
}