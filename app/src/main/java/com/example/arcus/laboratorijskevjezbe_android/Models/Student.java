package com.example.arcus.laboratorijskevjezbe_android.Models;

public class Student {
   private String ime;
   private String prezime;
   private String datum;
   private String predmet;
   private String profesor;
   private String godina;
   private String predavanja;
   private String ECTS;
   private String LV;

   public Student(String ime, String prezime, String datum, String predmet, String profesor, String godina, String predavanja, String ECTS, String LV){
       this.ime=ime;
       this.prezime = prezime;
       this.datum=datum;
       this.predmet=predmet;
       this.profesor=profesor;
       this.godina=godina;
       this.predavanja=predavanja;
       this.ECTS=ECTS;
       this.LV=LV;
   }

    public String getIme(){return ime;}
    public String getPrezime(){return prezime;}
    public String getDatum(){return datum;}
    public String getPredmet(){return predmet;}
    public String getProfesor(){return profesor;}
    public String getGodina(){return godina;}
    public String getPredavanja(){return predavanja;}
    public String getECTS(){return ECTS;}
    public String getLV(){return LV;}
}