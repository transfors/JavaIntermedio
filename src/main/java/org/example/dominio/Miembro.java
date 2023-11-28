package org.example.dominio;

public class Miembro {

    enum metodoContacto{
        Whatsapp,
        Email,
    }
    public metodoContacto metodoContacto;

    public void notificar() {
        if (metodoContacto == metodoContacto.Email) {
         // enviar mail
        }
        else if (metodoContacto == metodoContacto.Whatsapp) {
         // enviar whatsapp
        }
    }
}
