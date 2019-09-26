package com.example.plus.page;

import lombok.Data;

/**
 * PageNavigation:请求分页的规格,不传默认给个值比较科学(其实也可以使用JDK8 Optional类防止对象为空而出现空指针更加科学)
 *
 * @author zhangxiaoxiang
 * @date 2019/6/12
 */
@Data
public class PageNavigation {
    /**
     * 当前页(使用int可以有个默认值,但是是0,这里直接默认起始页为1,所以使用Integer,都可以使用)
     */
    private Integer pageNumber = 1;
    /**
     * 每页记录数
     */
    private Integer pageSize = 10;

}
