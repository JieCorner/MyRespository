package com.util;

import javax.swing.JOptionPane;

public class Regex {
	public static boolean checkReg(String username,String password){
		boolean username_flag = false;
		boolean password_flag = false;
		
		String username_regex = "[a-zA-Z]\\w{5,15}";		
		String password_regex = "\\w{6,15}";
		
		username_flag = username.matches(username_regex);
		password_flag = password.matches(password_regex);
		
		if(username_flag == true && password_flag == true){
			return true;
		}else {
			if(username_flag == false && password_flag == false){
				JOptionPane.showMessageDialog(null, "�û����������ʽ����");
			}else if(username_flag == false && password_flag == true){
				JOptionPane.showMessageDialog(null, "�û�����ʽ����");
			}else if(username_flag == true  && password_flag == false){
				JOptionPane.showMessageDialog(null, "�����ʽ����");
			}
			return false;
		}
	
	}
	
	public static boolean checkReg(String cName,
			String cPostCode,String cTel,String cLoginName,String cPassword){			
		String msg = "";
		
		String cName_regex = "[\u4E00-\u9FA5]{2,8}";		
		String cPostCode_regex = "[1-9]\\d{5}(?!\\d)";	
		String cTel_regex = "[1][358][0-9]{9}";	
		String cLoginName_regex = "[a-zA-Z]\\w{5,15}";	
		String cPassword_regex = "\\w{6,15}";	
		
		boolean cName_flag = cName.matches(cName_regex);
		boolean cPostCode_flag = cPostCode.matches(cPostCode_regex);
		boolean cTel_flag = cTel.matches(cTel_regex);
		boolean cLoginName_flag = cLoginName.matches(cLoginName_regex);
		boolean cPassword_flag = cPassword.matches(cPassword_regex); 
		
		if (!cName_flag) msg += "����,";
		if (!cPostCode_flag) msg += "��������,";
		if (!cTel_flag) msg += "�绰����,";
		if (!cLoginName_flag) msg += "ע����,";
		if (!cPassword_flag) msg += "����,";
		
		if(!(cName_flag && cPostCode_flag && cTel_flag && cLoginName_flag && cPassword_flag)){
			JOptionPane.showMessageDialog(null, msg + "��ʽ����ȷ");
		}

		return(cName_flag && cPostCode_flag && cTel_flag && cLoginName_flag && cPassword_flag)? true:false;
	}
	
	public static boolean checkReg(String sName, String sAddress,
			String sPostCode, String sTel, String sMail, String sLoginName,
			String sPassword) {
		String msg = "";	
		
		String sName_regex = ".{1,32}";
		String sAddress_regex = ".{1,100}";
		String sPostCode_regex = "[1-9]\\d{5}(?!\\d)";
		String sTel_regex = "[1][358][0-9]{9}";
		String sMail_regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
		String sLoginName_regex = "[a-zA-Z]\\w{5,15}";
		String sPassword_regex = "\\w{6,15}";
		
		boolean sName_flag = sName.matches(sName_regex);
		boolean sAddress_flag = sAddress.matches(sAddress_regex);
		boolean sPostCode_flag = sPostCode.matches(sPostCode_regex);
		boolean sTel_flag = sTel.matches(sTel_regex);
		boolean sMail_flag = sMail.matches(sMail_regex);
		boolean sLoginName_flag = sLoginName.matches(sLoginName_regex);
		boolean sPassword_flag = sPassword.matches(sPassword_regex);
		
		if(!sMail_flag) msg += "����,";
		if(!sAddress_flag) msg+="��ַ,";
		if (!sName_flag) msg += "����,";
		if (!sPostCode_flag) msg += "��������,";
		if (!sTel_flag) msg += "�绰����,";
		if (!sLoginName_flag) msg += "ע����,";
		if (!sPassword_flag) msg += "����,";
		
		if(!(sName_flag && sAddress_flag && sPassword_flag && sPostCode_flag && sTel_flag && sMail_flag && sLoginName_flag && sPassword_flag)){
			JOptionPane.showMessageDialog(null, msg + "��ʽ����ȷ");
		}
		

		return (sName_flag && sAddress_flag && sPassword_flag && sPostCode_flag && sTel_flag && sMail_flag && sLoginName_flag && sPassword_flag)?true:false;

	}

}
