package com.webtest.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月26日 下午5:09:38 
* 
* 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
* @param sourceFilePath :待压缩的文件路径
* @param zipFilePath :压缩后存放路径
* @param fileName :压缩后文件的名称
* @return
*/

public class FileToZIP {
	
	static File zipFile = null;
    static String sourceFilePath = "D:\\2016TrainingJava\\auto2018\\test-output\\html";
	static String zipFilePath = "D:\\2016TrainingJava\\test-output\\auto2018-ZIP";
	
	
	public FileToZIP(String fileName) {
		fileToZip(sourceFilePath,zipFilePath,fileName);
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
