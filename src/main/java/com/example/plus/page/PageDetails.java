package com.example.plus.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * PageDetails:返回分页的规格(比如查询了多少条)
 * @author zhangxiaoxiang
 * @date 2019/9/15
 */
@Component
@Data
public class PageDetails {
    /**
     * 当前页
     */
    private Integer pageNumber;

    /**
     * 每页的数量
     */
    private Integer pageSize;
    /**
     * 数据库查询出来的总记录数
     */
    private Long total;

    /**
     * 插件分页执行的结果
     * @param pageInfo
     * @return
     */
    public PageDetails getPageDetails(PageInfo pageInfo) {
        PageDetails pageDetails = new PageDetails();
        pageDetails.setPageNumber(pageInfo.getPageNum());
        pageDetails.setPageSize(pageInfo.getPageSize());
        pageDetails.setTotal(pageInfo.getTotal());
        return pageDetails;
    }

}
