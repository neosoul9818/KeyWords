package com.atguigu.mapper;

import java.util.HashMap;
import java.util.List;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import com.atguigu.bean.T_MALL_SKU;

public interface SearchMapper {

	List<OBJECT_T_MALL_SKU_KEYWORDS> select_sku_list_by_class_2(int class_2_id);

	List<OBJECT_T_MALL_SKU_KEYWORDS> select_skku_list_by_attr(HashMap<Object, Object> hashMap);

}
