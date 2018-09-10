/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

/**
 * Die Autentifizierung für die Validierung der Berechtigungen im Programm.
 * Die Benutzer sind fest vorgegeben. Für die produktive Verwendung muss eine Autentifizierung via Datenbank und Registrierung hinzugefügt werden.
 * @author ch.grossmann, t.baechler
 */
public class Authentication {

    private String username;
    private String password;
    private String usernameAdmin;
    private String passwortAdmin;
    private String userfunction;

    public Authentication() {
        setUsername("user");
        setPassword("user");
        setUsernameAdmin("admin");
        setPasswordAdmin("admin");
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getUsername() {
        return this.username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private String getPassword() {
        return this.password;
    }

    public String getUserfunction() {
        return this.userfunction;
    }

    private void setUserfunction(String function) {
        this.userfunction = function;
    }

    private String getUsernameAdmin() {
        return this.usernameAdmin;
    }

    private void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    private String getPasswordAdmin() {
        return this.passwortAdmin;
    }

    private void setPasswordAdmin(String passwortAdmin) {
        this.passwortAdmin = passwortAdmin;
    }

    /**
     * Setzt die Userfunktion anhand der Eingaben.
     * @param username
     * @param password
     * @return 
     */
    public Boolean authenticate(String username, String password) {
        if ((username.equals(getUsername()) && password.equals(getPassword())) || ((username.equals(getUsernameAdmin()) && password.equals(getPasswordAdmin())))) {
            if (username.equals(getUsername())) {
                setUserfunction("User");
            }
            if (username.equals(getUsernameAdmin())) {
                setUserfunction("Admin");
            }
            return true;
        }
        return false;
    }

}
