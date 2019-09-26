package com.example.plus.page;


import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * PageResponse :返回分页的所有相关信息和数据
 *
 * @author zhangxiaoxiang
 * @date 2019/9/15
 */
@Component
@Data
public class PageResponse<T> {
    /**
     * 分页详情
     */
    private PageDetails pageDetails;

    /**
     * 查询结果(分页数据)
     */
    private T pageDataList;

    /**
     * @param pageInfo
     * @return 完整分页结果集(给前端解析的)
     */
    public PageResponse getResultDataVO(PageInfo pageInfo) {
        PageResponse pageResponse = new PageResponse();
        PageDetails pageDetails = new PageDetails();
        pageDetails.setPageNumber(pageInfo.getPageNum());
        pageDetails.setPageSize(pageInfo.getPageSize());
        pageDetails.setTotal(pageInfo.getTotal());
        pageResponse.setPageDataList(pageInfo.getList());
        pageResponse.setPageDetails(pageDetails);
        return pageResponse;

    }

}
