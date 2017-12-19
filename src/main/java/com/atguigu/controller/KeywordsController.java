package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.util.MyPropertiesUtil;
import com.atguigu.util.MySolrUtil;

@Controller
public class KeywordsController {

	@RequestMapping(value = "keywords")
	@ResponseBody
	public List<OBJECT_T_MALL_SKU_KEYWORDS> keywords(@RequestParam("keywords") String keywords) {
		List<OBJECT_T_MALL_SKU_KEYWORDS> list_sku = new ArrayList<OBJECT_T_MALL_SKU_KEYWORDS>();

//		HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("solr.properties", "solr_sku"));
//		solr.setParser(new XMLResponseParser());
//		solr.setConnectionTimeout(3000);
//
//		SolrQuery solrQuery = new SolrQuery();
//
//		solrQuery.setQuery("copy_item:" + keywords);
//		solrQuery.setRows(50);
//
//		try {
//			QueryResponse query = solr.query(solrQuery);
//			list_sku = query.getBeans(OBJECT_T_MALL_SKU_KEYWORDS.class);
//		} catch (SolrServerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		list_sku = MySolrUtil.query_data("copy_item:" + keywords,OBJECT_T_MALL_SKU_KEYWORDS.class );
		return list_sku;
	}

}
