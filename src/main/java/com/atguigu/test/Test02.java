package com.atguigu.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import com.atguigu.util.MySolrUtil;

public class Test02 {

	public static void main(String[] args) {

		List<OBJECT_T_MALL_SKU_KEYWORDS> list_sku = new ArrayList<OBJECT_T_MALL_SKU_KEYWORDS>();
		
		list_sku = MySolrUtil.query_data("copy_item:小明", OBJECT_T_MALL_SKU_KEYWORDS.class);
		list_sku.forEach(System.out::println);
//		HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr/sku");
//		solr.setParser(new XMLResponseParser());
//		solr.setConnectionTimeout(3000);
//
//		SolrQuery solrQuery = new SolrQuery();
//
//		solrQuery.setQuery("sku_mch:小明");
//		solrQuery.setRows(50);
//
//		try {
//			QueryResponse query = solr.query(solrQuery);
//			list_sku = query.getBeans(OBJECT_T_MALL_SKU_KEYWORDS.class);
//		} catch (SolrServerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
