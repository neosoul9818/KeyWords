package com.atguigu.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import com.atguigu.factory.MySqlSessionFactory;
import com.atguigu.mapper.SearchMapper;
import com.atguigu.util.MySolrUtil;

public class Test01 {

	public static void main(String[] args) {

		// 调用sku查询方法，查询sku集合

		SqlSessionFactory myFactory = MySqlSessionFactory.getMyFactory();
		SearchMapper mapper = myFactory.openSession().getMapper(SearchMapper.class);

		List<OBJECT_T_MALL_SKU_KEYWORDS> list_sku = mapper.select_sku_list_by_class_2(28);

		// 将sku集合导入到solr中
		MySolrUtil.import_data(list_sku);
		
	}

}
