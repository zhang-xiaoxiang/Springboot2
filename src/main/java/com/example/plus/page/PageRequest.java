package com.example.plus.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * PageRequest:封装前端完整的分页请求
 *
 * @author zhangxiaoxiang
 * @date 2019/6/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {

    /**
     * 分页需求
     */
    private PageNavigation pageNavigation;

    /**
     *接收的具体对象
     */
    private PageCondition pageCondition;


}
