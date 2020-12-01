package com.PM.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PM.dao.ProductDao;
import com.PM.model.Product;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private String uploadPath;
	private SmartUpload smart;
    
    public ProductServlet() {
        super();       
    }
    public void init(){
    	productDao=new ProductDao();
		uploadPath = getServletContext().getRealPath("/")+"upload";
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setLocale(Locale.TAIWAN);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try{
            switch(action){
                case "/product/new":
                    showNewForm(request, response);
                    break;
                case "/product/insert":
                    insertProduct(request, response);
                    break;
//                case "/products/delete":
//                    deleteProduct(request, response);
//                    break;
                case "/products/edit":
                    showEditForm(request, response);
                    break;
                case "/products/update":
                    updateProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException(e);
        }
    }	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("../backend/products_info/form.jsp");		
		dispatcher.forward(request, response);
		
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String filename = "";
		try {
			//1）建立SmartUpload物件，
			smart = new SmartUpload();
			smart.initialize(getServletConfig(), request, response);
			//2）設定上傳限制（檔案的大小，型別）
			smart.setMaxFileSize(1024*1024*9);
			smart.setAllowedFilesList("jpg,png,gif");
			//3）呼叫SmartUpload物件的 upload()
			smart.upload();
			Files files = smart.getFiles();
			com.jspsmart.upload.File file1 = files.getFile(0); // 5.1）讀取本次上傳的檔案
			filename = file1.getFileName(); // 5.3）取得檔名
			file1.saveAs("upload/"+filename); // 5.4）呼叫檔案物件的 saveAs()方法
		} catch (SmartUploadException e) {			
			e.printStackTrace();
		}
		String picture = filename;
		//String products_id = request.getParameter("products_id");
		//System.out.println("try to get products_id");
		//System.out.println(products_id);
		
		/*
		Enumeration <String> e = request.getParameterNames();
		System.out.println("while test");
		while (e.hasMoreElements())
		       System.out.println(e.nextElement());
		*/
		
		
		int products_id = Integer.parseInt(smart.getRequest().getParameter("products_id"));    	
    	String products_name = smart.getRequest().getParameter("products_name");
        int stock = Integer.parseInt(smart.getRequest().getParameter("stock"));   
        String created_at = smart.getRequest().getParameter("created_at");
        String updated_at = smart.getRequest().getParameter("updated_at");
        Product newProduct = new Product(picture, products_id, products_name, stock, created_at, updated_at);
        productDao.insertProduct(newProduct);
        response.sendRedirect("list");

    }
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setLocale(Locale.TAIWAN);
		doGet(request, response);
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		List < Product > listProduct = productDao.selectAllProduct();
		RequestDispatcher dispatcher;
		int totalrows = listProduct.size();
		request.setAttribute("totalrows", totalrows);
		request.setAttribute("listProduct", listProduct);
		dispatcher = request.getRequestDispatcher("../backend/products_info/list.jsp");		
		dispatcher.forward(request, response);
	    System.out.println("test");
	}	
	
}
