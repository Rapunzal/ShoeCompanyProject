package com.simplilearn.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.PurchaseReport;
import com.simplilearn.service.PurchaseReportService;

@Controller
@RequestMapping("/company")
public class PurchaseReportController {

	@Autowired
	PurchaseReportService purchaseReportService;
	
	@GetMapping("/report")
	public String findAll(Model model) {
		List<PurchaseReport> report=purchaseReportService.findAll();
		model.addAttribute("report",report);
		return "displayreport";
	}
	
	@GetMapping("/datereport")
	public String dateReportForm(Model model) {
		List<PurchaseReport> report=purchaseReportService.findAll();
		model.addAttribute("report",report);
		return "dateReport";
	}
	
	@PostMapping("/reportbydate")
	public String findByDate(@RequestParam("date")String date,Model model) {
		Date d;
		try {
			System.out.println("String date "+date);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	         d = (Date) format.parse(date);
			//java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			
			System.out.println("date------>>>"+d);
			List<PurchaseReport> list=purchaseReportService.findByDate(d);
			model.addAttribute("report", list);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "reportByDate";
	}
	@PostMapping("/reportbycategory")
	public String findByCategory(@RequestParam("category")String category,Model model) {

			System.out.println("category------>>>"+category);
			List<PurchaseReport> list=purchaseReportService.findByCategory(category);
			model.addAttribute("report", list);
	
		return "reportByDate";
	}
	
}
