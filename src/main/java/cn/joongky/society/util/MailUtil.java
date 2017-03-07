package cn.joongky.society.util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class MailUtil {

	/**
	 * 简单邮件发送
	 * 
	 * @param title
	 * @param text
	 * @param mailto
	 *
	 * @throws Exception
	 */
	public static void sendMail(String title, String text, String mailto) throws Exception {
		Properties props = System.getProperties();
		// 创建信件服务器
		props.put("mail.smtp.host", ConfigUtil.getValue("mail_host"));
		props.put("mail.smtp.auth", ConfigUtil.getValue("mail_auth"));
		props.put("mail.transport.protocol", "smtp");
		// QQ邮箱专用 QQ邮箱需要的授权码 不是账号密码
		// MailSSLSocketFactory sf = new MailSSLSocketFactory();
		// sf.setTrustAllHosts(true);
		// props.put("mail.smtp.ssl.enable", "true");
		// props.put("mail.smtp.ssl.socketFactory", sf);
		// 得到默认的对话对象
		Authenticator a = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				/*
				 * return new PasswordAuthentication(
				 * prop.getProperty("mail.username"),
				 * prop.getProperty("mail.password"));
				 */
				return new PasswordAuthentication(ConfigUtil.getValue("mail_username"),
						ConfigUtil.getValue("mail_password"));
			}
		};
		// 创建Session实例
		Session session = Session.getDefaultInstance(props, a);
		// 创建MimeMessage实例对象
		MimeMessage msg = new MimeMessage(session);
		// 设置发信人
		// msg.setFrom(new InternetAddress(from));
		// 设置自定义发件人昵称
		String nick = "";
		try {
			nick = javax.mail.internet.MimeUtility.encodeText(ConfigUtil.getValue("system_name"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		msg.setFrom(new InternetAddress(ConfigUtil.getValue("mail_username"), nick));
		// 设置收信人
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailto));
		// 设置发送日期
		msg.setSentDate(new Date());
		// 设置邮件主题
		msg.setSubject(title);
		// 设置邮件正文(纯文本 )
		/* msg.setText(text); */
		// 设置邮件正文(HTML格式 )
		msg.setContent(text, "text/html;charset = UTF-8");
		Transport.send(msg);
	}

	/**
	 * 发送带附件的邮件
	 * 
	 * @param title
	 * @param text
	 * @param mailto
	 * @param addAttachfile
	 * @throws Exception
	 */
	public static void sendFileMail(String title, String text, String mailto, List<?> addAttachfile) throws Exception {
		// 获取邮件配置参数
		Properties props = System.getProperties();
		// 创建信件服务器
		props.put("mail.smtp.host", ConfigUtil.getValue("mail_host"));
		props.put("mail.smtp.auth", ConfigUtil.getValue("mail_auth"));
		props.put("mail.transport.protocol", "smtp");
		// 得到默认的对话对象
		Authenticator a = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(ConfigUtil.getValue("mail_username"),
						ConfigUtil.getValue("mail_password"));
			}
		};
		// 创建Session实例
		Session session = Session.getDefaultInstance(props, a);
		// 创建MimeMessage实例对象
		MimeMessage msg = new MimeMessage(session);
		// 设置发信人
		// msg.setFrom(new InternetAddress(from));
		// 设置自定义发件人昵称
		String nick = "";
		try {
			nick = javax.mail.internet.MimeUtility.encodeText("接入平台");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		msg.setFrom(new InternetAddress(ConfigUtil.getValue("mail_username"), nick));
		// 设置收信人
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailto));
		// 设置邮件主题
		msg.setSubject(title);
		Multipart mp = new MimeMultipart();
		MimeBodyPart mbp = new MimeBodyPart();
		// 设置邮件正文(HTML格式 )
		mbp.setContent(text, "text/html;charset = UTF-8");
		mp.addBodyPart(mbp);
		if (!addAttachfile.isEmpty()) {
			for (int i = 0; i < addAttachfile.size(); i++) {
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.removeHeader("Content-Type");
				mbp1.removeHeader("Content-Transfer-Encoding");
				mbp1.addHeader("Content-Type", "text/html; charset=UTF-8");
				mbp1.addHeader("Content-Transfer-Encoding", "base64");
				List<?> byteSources = (List<?>) addAttachfile.get(i);
				DataSource fds = new ByteArrayDataSource((byte[]) byteSources.get(1), "application/octet-stream");
				mbp1.setDataHandler(new DataHandler(fds));
				mbp1.setFileName(MimeUtility.encodeText((String) byteSources.get(0)));
				mp.addBodyPart(mbp1);
			}
		}
		msg.setContent(mp);
		// 设置发送日期
		msg.setSentDate(new Date());
		msg.saveChanges();
		Transport.send(msg);
	}
}
