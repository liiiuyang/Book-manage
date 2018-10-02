package com.tjetc.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SingleFileUploadServlet
 */
public class SingleFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleFileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取tomcat下的真实路径
		String path = this.getServletContext().getRealPath("/upload");
		String pathTemp = this.getServletContext().getRealPath("/temp");
		
		//创建临时文件的目录
		DiskFileItemFactory disk = new DiskFileItemFactory(1024*10,new File(pathTemp));
		
		//接收临时文件
		ServletFileUpload upload = new ServletFileUpload(disk);
		
		try {
			//解析request
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem file:list){
				//System.out.println(file);
				if(file.isFormField()){//如果是普通的表单数据，输出参数名称和参数的值
					String name = file.getFieldName();
					String value = file.getString("utf-8");
					System.out.println(name+"="+value);
				}else{//如果不是普通的表单数据，输出文件的名称
					String fileName = file.getName();
					System.out.println("文件名是："+fileName);
					//处理文件  完成文件的复制工作
					InputStream in = file.getInputStream();
					OutputStream out = new FileOutputStream(path+"/"+fileName);
					
					byte[] buf = new byte[1024];
					int len = 0 ;
					while((len=in.read(buf))!=-1){
						out.write(buf, 0, len);
					}
					
					out.flush();
					//关闭流
					out.close();
					
					
					
				}
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
