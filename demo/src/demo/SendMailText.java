package demo;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/** 
* author:shenmengqi 
* @version 创建时间：2018年11月20日 下午4:29:03 
* 类说明 
*/
public class SendMailText {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        
        Session session = Session.getInstance(props);
        session.setDebug(true);
        
        Message msg = new MimeMessage(session);
        msg.setSubject("这是一个测试程序....");
        msg.setText("你好!这是我的第一个javamail程序---沈梦琪");
        msg.setFrom(new InternetAddress("18232893500@163.com"));

        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", 25, "18232893500@163.com", "shenmengqi123");
         transport.sendMessage(msg,new Address[]{new InternetAddress("1144837048@qq.com")});

        System.out.println("邮件发送成功...");
        transport.close();
    }
}