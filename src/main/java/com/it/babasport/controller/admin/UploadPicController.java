package com.it.babasport.controller.admin;
import org.json.JSONObject;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.jersey.api.client.Client;

import com.sun.jersey.api.client.WebResource;


@Controller
public class UploadPicController {
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,HttpServletResponse response) throws IOException{
			Client client=new Client();
			//获取当前时间字符串
			DateFormat dateFormat=new SimpleDateFormat("YYYYmmddHHmmssSSS");
			String date=dateFormat.format(new Date());
	
			//获取随机3个数拼接
			Random random=new Random();
			for(int i=0;i<3;i++){
				date+=random.nextInt(10);
			}
			String ete=FilenameUtils.getExtension(pic.getOriginalFilename());

			String path="upload/"+date+"."+ete;
			String url="http://localhost:8088/pic-web/"+path;
			WebResource webResource= client.resource(url);
			try {
				webResource.put(String.class, pic.getBytes());
			}  catch (IOException e) {
			
				e.printStackTrace();
			}
			JSONObject jsonObject=new JSONObject();
		
				jsonObject.put("path", path);
				jsonObject.put("url", url);
		
			String str=jsonObject.toString();
			response.getWriter().write(str);
	
	}
//	@RequestMapping(value="/upload/uploadFck.do")
//	public void uploadfck(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		//强转request  支持多个
//				MultipartHttpServletRequest mr= (MultipartHttpServletRequest)request;
//			
//				//获取值  支持多个
//			
//				Map<String, MultipartFile> fileMap = mr.getFileMap();
//				//遍历Map
//			
//				Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
//				for(Entry<String, MultipartFile> entry : entrySet){
//					//上传上来的图片
//					MultipartFile pic = entry.getValue();
//					//扩展名
//					String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
//					
//					//图片名称生成策略
//					DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//					//图片名称一部分
//					String format = df.format(new Date());
//					
//					//随机三位数
//					Random r = new Random();
//					// n 1000   0-999   99
//					for(int i=0 ; i<3 ;i++){
//						format += r.nextInt(10);
//					}
//					
//					//实例化一个Jersey
//					Client client = new Client();
//					//保存数据库
//					String path = "upload/" + format + "." + ext;
//					
//					//另一台服务器的请求路径是?
//					String url = "http://localhost:8088/" + path;
//					//设置请求路径
//					WebResource resource = client.resource(url);
//					
//					//发送开始  POST  GET   PUT
//					try {
//						resource.put(String.class, pic.getBytes());
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					//返回Url给Fck   fck-core...jar   ckeditor
//				
//					JSONObject jsonObject=new JSONObject();
//					
//					jsonObject.put("url", url);
//					
//					String str=jsonObject.toString();
//					response.getWriter().write(str);
//					//返回Url给Fck   fck-core...jar   ckeditor
//					UploadResponse ok = new UploadResponse();
//					ok.setCustomMessage(url);
//					//response 返回对象 
//					//response  write 
//					//response  print
//					//区别:
//					//字符流
//					//字节流
//					try {
//						response.getWriter().print(ok);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//
//	}
//	}
	}
