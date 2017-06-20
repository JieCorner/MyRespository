package com.mail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailTest {
	public static void main(String[] args) throws MessagingException, IOException {
        Properties properties=new Properties();
        properties.setProperty("mail.host", "smtp.163.com");//设置服务器主机
        properties.setProperty("mail.smtp.auth", "true");//设置是否进行身份验证，必须为true

        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("m18054251458@163.com", "gengjie186155");//发件人的用户名和第三方登录授权码
            }
        };

        Session session=Session.getInstance(properties, authenticator);//创建连接会话

        MimeMessage message=new MimeMessage(session);//创建消息

        MimeMultipart mimeMultipart=new MimeMultipart();//创建多条消息内容容器

        MimeBodyPart part01=new MimeBodyPart();//创建内容
        part01.setContent("欢迎进入北斗狼神的世界，这里是狼神的主页 www.domarvel.cn", "text/html;charset=utf-8");

//        MimeBodyPart part02=new MimeBodyPart();
//        part02.attachFile(new File("S:/任务/FireLang.jpg"));//创建附件
//        part02.setFileName(MimeUtility.encodeText("胡艺宝.jpg"));

        MimeBodyPart part03=new MimeBodyPart();
        part03.setContent("FIRELANG---HUYIBAO", "text/html;charset=utf-8");//因为已经设置了邮件主体，所以这一个信息是不会看到的。但是会发到服务器。

        mimeMultipart.addBodyPart(part01);//添加内容到容器
//        mimeMultipart.addBodyPart(part02);
        mimeMultipart.addBodyPart(part03);

        message.setContent(mimeMultipart);//把多条消息装进要发送消息里面
        message.setSubject("FireLang官方邮件");//设置邮件标题
        message.setFrom(new InternetAddress("m18054251458@163.com"));//设置发件人
        message.setRecipients(RecipientType.BCC, "1554608814@qq.com");//设置收件人，并且发送方式为密送,BBC密送，CC抄送，TO正常发送，多个收件人用逗号隔开，在收件人字符串里面

        Transport.send(message);//发送邮件
        System.out.println("发送成功!!!");
    }
}
