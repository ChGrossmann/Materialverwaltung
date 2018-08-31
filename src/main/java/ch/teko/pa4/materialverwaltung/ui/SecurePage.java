/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SecurePage extends VerticalLayout implements View {
	private static final long serialVersionUID = 1L;
	private Label secure;
	private Label currentUser;
	private Button logout;
        private Button forward;
	public static final String NAME = "Secure";

	public SecurePage() {
		
		
		logout = new Button("Ausloggen");
		logout.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(SecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment("");
                         
			}
		});
                
                forward = new Button("Fortsetzen");
                forward.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
                                Page.getCurrent().setUriFragment("");
				Page.getCurrent().reload();                       
			}
		});
                
		
		secure = new Label("Eingeloggt");
		currentUser = new Label("Current User");
		addComponent(secure);
		addComponent(currentUser);
		addComponent(logout);
                addComponent(forward);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		currentUser.setCaption("Aktueller Benutzer : " + VaadinSession.getCurrent().getAttribute("user").toString());                  
	}

}
