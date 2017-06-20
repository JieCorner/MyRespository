package com.spring2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory
{
	private Map<String,Object> beans=new HashMap<String,Object>();
	
	public ClassPathXmlApplicationContext() throws Exception{
		SAXBuilder sb=new SAXBuilder();
		Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		Element root=doc.getRootElement();//取得根元素
		List list=root.getChildren("bean");//取得名字为bean的所有元素
		for(int i=0;i<list.size();i++){
			Element element=(Element)list.get(i);
			String id=element.getAttributeValue("id");
			String clazz=element.getAttributeValue("class");
			System.out.println(id+":"+clazz);
			
			Object o=Class.forName(clazz).newInstance();
			beans.put(id, o);
			//判断有没有property
			for(Element propertyElement:(List<Element>)element.getChildren("property")){
				String name=propertyElement.getAttributeValue("name");
				String bean=propertyElement.getAttributeValue("bean");
				Object beanObject=beans.get(bean);
				//set方法
				String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
				System.out.println("method name="+methodName);
				//调用
				Method m=o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);
			}
			
			
		}
	}
	
	@Override
	public Object getBean(String name)
	{
		return beans.get(name);
	}
}
