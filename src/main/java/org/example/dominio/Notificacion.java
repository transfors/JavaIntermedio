package org.example.dominio;

public class Notificacion{
   public String Titulo;

   public String Cuerpo;

   public Incidente Incidente;

   public boolean enviado;

   public Notificacion(String Titulo, String Cuerpo, Incidente Incidente){
      this.Titulo = Titulo;
      this.Cuerpo = Cuerpo;
      this.Incidente = Incidente;
      this.enviado = false;
   }

}
