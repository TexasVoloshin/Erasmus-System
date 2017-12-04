/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erazmus.system;

/**
 *
 * @author KasiaW
 */
public class Erasmus {
    //private int eId;
    private String first_name;
    private String last_name;
    private String gender;
    private String country;
    private String email;
    private String telephone;
    private String university;
    private String supervisor_last_name;
    
     public Erasmus(int EId,String EName,String ELastName,String EGender,String ECountry, String EEmail,String EPhone,String EUni, String ESupervisor)
    {
        //this.eId = EId;
        this.first_name = EName;
        this.last_name = ELastName;
        this.gender = EGender;
        this.country = ECountry;
        this.email=EEmail;
        this.telephone =EPhone;
        this.university=EUni;
        this.supervisor_last_name=ESupervisor;
        
    }
    
   // public int getEId()
    //{
     //   return eId;
    //}
    
    public String getEname()
    {
        return first_name;
    }
    public String getELastName()
    {
        return last_name;
    }
    public String getEGender()
    {
        return gender;
    }
    public String getECountry()
    {
        return country;
    }
    public String getEEmial()
    {
        return email;
    }
    public String getEPhone()
    {
        return telephone;
    }
    
    public String getEUni()
    {
        return university;
    }
    public String getESupervisor()
    {
        return supervisor_last_name;
    }
    
}


//http://1bestcsharp.blogspot.com/2015/11/java-sorting-jtable-columns-data-code.html