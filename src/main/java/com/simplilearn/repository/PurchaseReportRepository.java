package com.simplilearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.entity.PurchaseReport;

public interface PurchaseReportRepository  extends CrudRepository<PurchaseReport,Integer>{

	public List<PurchaseReport> findByDate(Date date);
	
	public List<PurchaseReport> findByCategory(String category);
}
