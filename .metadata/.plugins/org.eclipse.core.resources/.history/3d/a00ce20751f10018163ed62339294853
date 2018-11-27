package com.webtest.utils;


import java.util.Date;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月20日 下午4:34:13 
* 压缩test-output文件夹，发送邮件
*/

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.annotations.Test;


public class JavaMail {
	public JavaMail() {}
	
    /**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * @param sourceFilePath :待压缩的文件路径
	 * @param zipFilePath :压缩后存放路径
	 * @param fileName :压缩后文件的名称
	 * @return
	 */
	
	static File zipFile = null;
    static String sourceFilePath = "D:\\2016TrainingJava\\auto2018\\test-output\\html";
	static String zipFilePath = "D:\\2016TrainingJava\\test-output\\auto2018-ZIP";

	
	static String fromemail = "18232893500@163.com";
	static String fromshouquanma = "shenmengqi123";
//	static String toemail = "601322422@qq.com";
	static String toemail = "shenmq163@163.com";
	
	
	public void sendmail() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String nowDateTime=sdf.format(new Date());
		
		String fileName = "testoutput"+nowDateTime;
		
		
		fileToZip(sourceFilePath, zipFilePath, fileName);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		
		// 如果使用ssl，则去掉使用25端口的配置，进行如下配置, 
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
		
		
		// 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                return new PasswordAuthentication(fromemail, fromshouquanma);
            }
        };
        
        // 使用环境属性和授权信息，创建邮件会话
		Session session = Session.getInstance(props,authenticator);
 
		try {
			 // 创建邮件消息
			Message message = new MimeMessage(session);
			

	        // 设置发件人
			message.setFrom(new InternetAddress(fromemail));
		    // 设置收件人
			message.setRecipients(MimeMessage.RecipientType.TO,InternetAddress.parse(toemail));
			// 设置邮件标题
			message.setSubject("测试错误报告");
	        // 设置邮件的内容体
	        message.setContent("测试的HTML邮件", "text/html;charset=UTF-8");

	        
			// 创建一个MimeBodyPart的对象，以便添加内容
			BodyPart messageBodyPart1 = new MimeBodyPart();
			// 设置邮件正文内容
			messageBodyPart1.setText("这个是邮件的正文部分，此邮件应包含压缩文件，压缩文件中包含错误分析报告");
			
			// 设置邮件中附件文件的路径
			String filename = zipFilePath+"\\"+fileName+".zip";
			
			// 创建一个datasource对象，并传递文件
			DataSource source = new FileDataSource(filename);
			// 设置handler
			messageBodyPart1.setDataHandler(new DataHandler(source));
			// 加载文件
			messageBodyPart1.setFileName(filename);

			// 创建一个MimeMultipart类的实例对象
			Multipart multipart = new MimeMultipart();
			// 添加正文1内容
			multipart.addBodyPart(messageBodyPart1);
			// 设置内容
			message.setContent(multipart);
			// 最终发送邮件
			Transport.send(message);
			System.out.println("=====邮件已经发送=====");
		} catch (MessagingException e) {
			   throw new RuntimeException(e);
		}
 
	}
     
   
	
    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){
    	boolean flag = false;
    	File sourceFile = new File(sourceFilePath);
    	FileInputStream fis = null;
    	BufferedInputStream bis = null;
    	FileOutputStream fos = null;
    	ZipOutputStream zos = null;
    		
    	if(sourceFile.exists() == false){
    		System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
    	}else{
    		try {
    			zipFile = new File(zipFilePath + "/" + fileName +".zip");
    			if(zipFile.exists()){
    				System.out.println("");
    				zipFile.delete();
//    				System.out.println("删除成功");	
    			}
    			File[] sourceFiles = sourceFile.listFiles();
    				if(null == sourceFiles || sourceFiles.length<1){
    					System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
    				}else{
    					fos = new FileOutputStream(zipFile);
    					zos = new ZipOutputStream(new BufferedOutputStream(fos));
    					byte[] bufs = new byte[1024*10];
    					for(int i=0;i<sourceFiles.length;i++){
    						//创建ZIP实体，并添加进压缩包
    						ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
    						zos.putNextEntry(zipEntry);
    						//读取待压缩的文件并写进压缩包里
    						fis = new FileInputStream(sourceFiles[i]);
    						bis = new BufferedInputStream(fis, 1024*10);
    						int read = 0;
    						while((read=bis.read(bufs, 0, 1024*10)) != -1){
    							zos.write(bufs,0,read);
    						}
    						bis.close();
   						}
   						flag = true;
   					}
   				} catch (FileNotFoundException e) {
   					e.printStackTrace();
   					throw new RuntimeException(e);
   					} catch (IOException e) {
   						e.printStackTrace();
   						throw new RuntimeException(e);
   						} finally{
   							//关闭流
   							try {
   								if(null != bis) bis.close();
   								if(null != zos) zos.close();
   								} catch (IOException e) {
   									e.printStackTrace();
   									throw new RuntimeException(e);
   									}
   							}
    		}
    	return flag;
    	}
    
}