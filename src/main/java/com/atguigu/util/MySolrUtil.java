package com.atguigu.util;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;

public class MySolrUtil {
	
	public static <T> void  import_data(List<T> list) {
		HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("solr.properties", "solr_sku"));
		solr.setParser(new XMLResponseParser());
		solr.setConnectionTimeout(3000);

		try {
			solr.addBeans(list);
			
			solr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新solr
	 * @param list
	 */
	public static <T> void  update_data(List<T> list) {
		HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("solr.properties", "solr_sku"));
		solr.setParser(new XMLResponseParser());
		solr.setConnectionTimeout(3000);
		
		try {
			//先删除，再添加
//			solr.deleteByQuery("");
//			solr.deleteById(id);
//			solr.addBean(obj);
//			
//			solr.addBeans(list);
			
			solr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 全文检索，查询dsl_str *:*
	 * @param dsl_str 查询条件
	 * @param t 返回查询结果的类型
	 * @return
	 */
	public static <T> List<T> query_data(String dsl_str,Class<T> t){
		HttpSolrServer solr = new HttpSolrServer(MyPropertiesUtil.getMyProperty("solr.properties", "solr_sku"));
		solr.setParser(new XMLResponseParser());
		solr.setConnectionTimeout(3000);

		SolrQuery solrQuery = new SolrQuery();

		solrQuery.setQuery(dsl_str);
		solrQuery.setRows(50);

		try {
			QueryResponse query = solr.query(solrQuery);
			List<T> list = query.getBeans(t);
			
			return list;
		} catch (SolrServerException e) {
			e.printStackTrace();
			return null;
		}
	}
}
