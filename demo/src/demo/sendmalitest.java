package demo;


/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��20�� ����4:35:02 
* ��˵�� 
*/


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.annotations.Test;
/**
 * ���ļ���������ļ�
 * �����zipѹ���ļ�
 * 
 * @author admin
 *
 */
public final class sendmalitest {
 
	private sendmalitest(){}
	
	/**
	 * �������sourceFilePathĿ¼�µ�Դ�ļ��������fileName���Ƶ�zip�ļ�������ŵ�zipFilePath·����
	 * @param sourceFilePath :��ѹ�����ļ�·��
	 * @param zipFilePath :ѹ������·��
	 * @param fileName :ѹ�����ļ�������
	 * @return
	 */

	static File zipFile = null;
	public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){
		boolean flag = false;
		File sourceFile = new File(sourceFilePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		
		if(sourceFile.exists() == false){
			System.out.println("��ѹ�����ļ�Ŀ¼��"+sourceFilePath+"������.");
		}else{
			try {
				zipFile = new File(zipFilePath + "/" + fileName +".zip");
				if(zipFile.exists()){
					System.out.println("");
					zipFile.delete();
					System.out.println("ɾ���ɹ�");	
				}
				File[] sourceFiles = sourceFile.listFiles();
					if(null == sourceFiles || sourceFiles.length<1){
						System.out.println("��ѹ�����ļ�Ŀ¼��" + sourceFilePath + "���治�����ļ�������ѹ��.");
					}else{
						fos = new FileOutputStream(zipFile);
						zos = new ZipOutputStream(new BufferedOutputStream(fos));
						byte[] bufs = new byte[1024*10];
						for(int i=0;i<sourceFiles.length;i++){
							//����ZIPʵ�壬����ӽ�ѹ����
							ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
							zos.putNextEntry(zipEntry);
							//��ȡ��ѹ�����ļ���д��ѹ������
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
				//�ر���
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
	
	@Test
	public void fileToZip(){
		String sourceFilePath = "D:\\JavaSE\\eclipse\\work\\Shisujia\\test-output\\html";
		String zipFilePath = "D:\\JavaSE\\eclipse\\work\\Shisujia\\test-output";
		String fileName = "htmlzip";
		boolean flag = sendmalitest.fileToZip(sourceFilePath, zipFilePath, fileName);
		if(flag){
			System.out.println("�ļ�����ɹ�!");
		}else{
			System.out.println("�ļ����ʧ��!");
		}
	}
	
}
