package com.hibernate.annotation.bean;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_student")
public class TStudent  
{  
      
    public TStudent(String id,String name,String password,int age)  
    {  
        this.id = id;  
        this.name = name;  
        this.password = password;  
        this.age = age;  
    }  
      
    public TStudent()  
    {  
    }  
 
    @Id
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    @Column(name="t_id",nullable = false,unique = true)  
    private String id;  
      
    @Column(name="t_name")  
    private String name;  
      
    @Column(name="t_pwd")  
    private String password;  
      
    @Column(name="age")  
    private int age;  
  
    public String getId()  
    {  
        return id;  
    }  
  
    public void setId(String id)  
    {  
        this.id = id;  
    }  
  
    public String getName()  
    {  
        return name;  
    }  
  
    public void setName(String name)  
    {  
        this.name = name;  
    }  
  
    public String getPassword()  
    {  
        return password;  
    }  
  
    public void setPassword(String password)  
    {  
        this.password = password;  
    }  
  
    public int getAge()  
    {  
        return age;  
    }  
  
    public void setAge(int age)  
    {  
        this.age = age;  
    }  
      
    public String toString()  
    {  
        return  "[id:"+id+",name:"+name+",age:"+age+"]";  
    }  
      
} 