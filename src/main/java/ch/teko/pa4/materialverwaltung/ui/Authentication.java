/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

public class Authentication {
	
	private String username;
	private String password;
        private String userfunction;


	
	public Authentication() {
		setUsername("test");
		setPassword("test");
                setUserfunction("test");
	}

	private void setUsername(String username) {
		this.username = username;
	}
	
	private String getUsername(){
		return this.username;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	private String getPassword(){
		return this.password;
	}

        public String getUserfunction() {
            return userfunction;
        }

        public void setUserfunction(String function) {
            this.userfunction = function;
        }        
        
	public Boolean authenticate(String username, String password){
		if(username.equals(getUsername()) && password.equals(getPassword())){
			return true;
		}
		return false;
	}

}
