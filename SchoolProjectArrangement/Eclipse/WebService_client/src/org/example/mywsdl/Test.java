package org.example.mywsdl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

public class Test
{
	public static void main(String[] args) throws SOAPException, IOException
	{
		String ns="http://www.example.org/mywsdl/";
		QName name=new QName(ns,"MyServiceImplService");
		URL url=new URL("http://localhost:8989/ms?wsdl");
		
		MyServiceImplService mis=new MyServiceImplService(url,name);
		IMyService ms=mis.getMyServiceImplPort();
		System.out.println("客户端："+ms.divide(29, 3));
		
		
		System.out.println("----header-----");
		
		
		Service service=Service.create(url,name);
		QName pname=new QName(ns,"MyServiceImplPort");
		
		Dispatch<SOAPMessage> dis=service.createDispatch(pname, SOAPMessage.class, Service.Mode.MESSAGE);
		SOAPMessage msg=MessageFactory.newInstance().createMessage();
		SOAPEnvelope enve=msg.getSOAPPart().getEnvelope();
		SOAPHeader header=enve.getHeader();
		SOAPBody body=enve.getBody();
		if(header==null) header=enve.addHeader();
		QName hname=new QName(ns,"licenseInfo","ns");
		header.addHeaderElement(hname).setValue("added header messages!!");
		
		QName bname=new QName(ns,"add","ns");
		SOAPBodyElement ele=body.addBodyElement(bname);
		ele.addChildElement("a").setValue("12");
		ele.addChildElement("b").setValue("33");
		//输出发送给服务器端的soap报文
		msg.writeTo(System.out);
		
		System.out.println("\n invoking...");
		//输出服务器返回的soap报文
		SOAPMessage rep=dis.invoke(msg);
		rep.writeTo(System.out);
		
		
	}
}
