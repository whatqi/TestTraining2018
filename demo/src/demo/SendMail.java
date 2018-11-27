package demo;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

import org.testng.annotations.Test;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��11��20�� ����2:34:21 
* �����ʼ���
*/

public class SendMail {
	
	public static void sendmail() {
		//����һ��Property�ļ�����
		Properties props = new Properties();
 
		// �����ʼ�����������Ϣ����������smtp��������
		props.put("mail.smtp.host", "smtp.163.com");
 
		// ����socket factory �Ķ˿�
		props.put("mail.smtp.socketFactory.port", "465");
 
		// ����socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// ������Ҫ������֤
		props.put("mail.smtp.auth", "true");
 
		// ����SMTP�Ķ˿ڣ�QQ��smtp�˿���25
		props.put("mail.smtp.port", "25");
 
		// ������֤ʵ��
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
 
			protected PasswordAuthentication getPasswordAuthentication() {
                        // �ڶ��������������ҷ����ʼ������俪��smtp����Ȩ��
			return new PasswordAuthentication("18232893500@163.com", "shenmengqi123");
 
			}
 
		});
 
		try {
 
			// ����һ��MimeMessage���ʵ������
			Message message = new MimeMessage(session);
 
			// ���÷����������ַ
			message.setFrom(new InternetAddress("18232893500@163.com"));
 
			// �����ռ��������ַ
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1144837048@qq.com"));
            
            // �����ʼ�����
			message.setSubject("���Է����ʼ�");
 
			// ����һ��MimeBodyPart�Ķ����Ա���������
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// �����ʼ���������
			messageBodyPart1.setText("������ʼ������Ĳ���");
 
			// ��������һ��MimeBodyPart�����Ա�������������
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
 
			// �����ʼ��и����ļ���·��
			String filename = "D:\\2016TrainingJava\\auto2018\\test-output\\html\\index.html";
 
			// ����һ��datasource���󣬲������ļ�
			DataSource source = new FileDataSource(filename);
 
			// ����handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
 
			// �����ļ�
			messageBodyPart2.setFileName(filename);
 
			// ����һ��MimeMultipart���ʵ������
			Multipart multipart = new MimeMultipart();
 
			// ��������1����
			multipart.addBodyPart(messageBodyPart1);
 
			// ��������2����
			multipart.addBodyPart(messageBodyPart2);
 
			// ��������
			message.setContent(multipart);
 
			// ���շ����ʼ�
			Transport.send(message);
 
//			System.out.println("=====�ʼ��Ѿ�����=====");
 
		} catch (MessagingException e) {
 
			   throw new RuntimeException(e);
 
		}
 
	}
	
}
