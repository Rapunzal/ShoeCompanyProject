package com.simplilearn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.PurchaseReport;
import com.simplilearn.repository.PurchaseReportRepository;

@Service
public class PurchaseReportService {

	@Autowired
	PurchaseReportRepository purchaseReportRepository;
	
	public List<PurchaseReport> findAll() {
		List<PurchaseReport> report=new ArrayList<PurchaseReport>();
		purchaseReportRepository.findAll().forEach(r->report.add(r));
		return report;
	}
	
	public List<PurchaseReport> findByDate(Date date){
		List<PurchaseReport> list=purchaseReportRepository.findByDate(date);
		return list;
	}
	
	public List<PurchaseReport> findByCategory(String category){
		List<PurchaseReport> list=purchaseReportRepository.findByCategory(category);
		return list;
	}
}
