package com.example.plus.page;

import com.example.plus.result.BaseEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.*;

/**
 * <p>
 * BaseEntityUtil:
 * </p>
 *
 * @author zhangxiaoxiang
 * @since 2019-09-18
 */
public class MybatisResultMap {
    /**
     * 获取
     * @param list
     * @return
     */
  public static List<BaseEntity> getResultMap(List<Map<String,Object>> list){
      BaseEntity baseEntity;
      List<Map<String,Object>> listall=new ArrayList<>();
      List<BaseEntity> list1=new ArrayList<>();
      for (int i = 0; i < list.size(); i++) {
          baseEntity=new BaseEntity();
          Map<String, Object> map = list.get(i);
          listall.add(map);
          baseEntity.setMap(map);
          list1.add(baseEntity);
      }
      return list1;
  }
  // public static PageInfo<BaseEntity> startPage2(int pageNum, int pageSize, List<Map<String, Object>> baseMap){
  //     PageHelper.startPage(pageNum, pageSize);
  //     List<BaseEntity> entityList = MybatisResultMap.getResultMap(baseMap);
  //     PageInfo<BaseEntity> pageInfo = new PageInfo<>(entityList);
  //     /**
  //      * 1:是因为在前面对PageInfo构造的时候不是分页的对象,中间经过特殊处理,那么list instanceof Page不成立,进入else if,查看源码
  //      * 这里直接重新赋值,把丢失的数据赋值上去
  //      */
  //     pageInfo.setTotal(baseMap.size());
  //     pageInfo.setPageNum(pageNum);
  //     pageInfo.setPageSize(pageSize);
  //     return pageInfo;
  //
  //   }

}
