package com.defysope.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defysope.Constant;
import com.defysope.model.ProductMaster;
import com.defysope.model.User;
import com.defysope.model.kv.Company;
import com.defysope.model.kv.CompanyLicenceDetails;
import com.defysope.navigation.Menu;
import com.defysope.service.ApplicationUtils;
import com.defysope.service.PublicManager;
import com.defysope.service.UserService;
import com.defysope.service.impl.Navigation;

@Controller
public class RegisterCompanyController {

	@Autowired
	private Navigation navigation;
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private PublicManager manager;
	
	@Autowired
	private UserService userService;
	
													
	// ============================= loading product list ===============
	@RequestMapping(value = "/load-product-list", method = RequestMethod.GET)
	@ResponseBody
	public Object loadproductList(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<ProductMaster> productList = manager.getObjects(ProductMaster.class);
		model.put("productList", productList);
		return model;
	}
	
	@RequestMapping(value = "/company-registration", method = RequestMethod.GET)
	public ModelAndView getBookmarkListPage(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> model = new HashMap<String,Object>();
		return new ModelAndView("company-registration",model);
	}
	
	@RequestMapping(value = "/save-company-registration", method = RequestMethod.POST)
	public @ResponseBody
	Object saveSignUpForm(HttpServletRequest request, @RequestBody Company company) {

		Map<String, Object> model = new HashMap<String, Object>();
		company.setCreatedUser(0);
		company.setLastUpdatedUser(0);
		company.setLastUpdatedLogin(0);
		company.setApprovedBy(0);
		manager.saveObject(company);
		
		// saving product licence details
		for(int i = 0; i< +company.getProductList().length; i++) {
			CompanyLicenceDetails licenceDetails = new CompanyLicenceDetails();
			licenceDetails.setCmpId(company.getCmpId());
			licenceDetails.setProductId((int) company.getProductList()[i]);
			
			manager.saveObject(licenceDetails); 
		}
		return model;
	}
	
	@Menu(title = "Company List", url = "/administration/company-list", accessCode = "ROLE_DF_APPROVE_COMPANY", order = 2, visible = true)
	@RequestMapping(value = "/administration/company-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_APPROVE_COMPANY")
	public ModelAndView listCompanyFtl(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", utils.getLoggedInUser());
		model.put("menus", navigation.displayMenuList());
		model.put("productlist", userService.getProductList(utils.getLoggedInUser().getCmpId()));
		return new ModelAndView("administration/company-list", model);
	}
	
	@RequestMapping(value = "/administration/laod/company-list", method = RequestMethod.GET)
	@Secured("ROLE_DF_APPROVE_COMPANY")
	@ResponseBody
	public Object loadCompanies(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Company> companies = manager.getObjects(Company.class);
		model.put("viewCompanies", companies );
		return model;
	}
	
	@RequestMapping(value = "/administration/approve/company", method = RequestMethod.POST)
	@Secured("ROLE_DF_APPROVE_COMPANY")
	@ResponseBody
	public Object approveCompany(HttpServletRequest request, @RequestBody Company thisCompany) {
		// approving company 
		thisCompany.setApprovedBy(utils.getLoggedInUser().getId());
		thisCompany.setApprovedOn(new Timestamp(System.currentTimeMillis()));
		thisCompany.setApproved(true);
		
		// creating user for company
		
		manager.saveObject(thisCompany);
		User user = new User();
		user.setUserName(thisCompany.getContactEmailId());
		user.setPassword(utils.encryptPassword("sa"));
		user.setBriefcasePassword(utils.encryptPassword("sa"));
		user.setUserType(User.STUDENT);
		user.setCmpId(thisCompany.getCmpId());
		user.setName(thisCompany.getContactName());
		user.setEmail(thisCompany.getContactEmailId());
		manager.saveObject(user);
		
		userService.saveUserInfo(user, Constant.ROLE_COMPANY_ADMIN);
		
		// saving in CompanyLicenceDetails
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("success", true); 
		return model;
	} 
}