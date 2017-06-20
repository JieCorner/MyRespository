package com.news.management.action;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAvatarAction extends ActionSupport {
	private String username;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return "E:/NewsUpdateAvatar";
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Override
	public String execute() throws Exception {
		String[] FileSuffix=getUploadFileName().split("\\.");
		String suffix=FileSuffix[FileSuffix.length-1];
		String UploadFileName=username+"."+suffix;
		String filePath=getSavePath()+"\\"+UploadFileName;
		InputStream is=new FileInputStream(getUpload());
		OutputStream os=new FileOutputStream(filePath);
		byte buffer[]=new byte[1024];
		int len=0;
		while((len=is.read(buffer))>0){
			os.write(buffer,0,len);
		}
		os.close();
		is.close();
		if(suffix.equals("png")){
			try {
				  BufferedImage bufferedImage;
			      bufferedImage = ImageIO.read(new File(filePath));
			      BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
			            bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			      newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
			      ImageIO.write(newBufferedImage, "jpg", new File(getSavePath()+"\\"+username+".jpg"));
			      File f = new File(filePath);
			      f.delete();
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
		return SUCCESS;
	}
}
