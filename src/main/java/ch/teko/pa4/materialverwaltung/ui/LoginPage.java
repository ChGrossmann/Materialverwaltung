/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.teko.pa4.materialverwaltung.ui;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Hiermit wird die LoginPage definiert mit der Eingabemaske.
 * @author t.baechler, ch.grossmann
 */
public class LoginPage extends VerticalLayout implements View {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "";

    
    public LoginPage() {
        Panel panel = new Panel("Login");
        panel.setSizeUndefined();
        addComponent(panel);

        FormLayout content = new FormLayout();
        TextField username = new TextField("Username");
        content.addComponent(username);
        PasswordField password = new PasswordField("Password");
        content.addComponent(password);

        Button login = new Button("Login");
        login.addClickListener(new ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                loginAction(username.getValue(), password.getValue());
            }

        });

        ShortcutListener shortcut = new ShortcutListener("Login", ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                loginAction(username.getValue(), password.getValue());

            }
        };

        login.addShortcutListener(shortcut);

        content.addComponent(login);
        content.setSizeUndefined();
        content.setMargin(true);
        panel.setContent(content);
        setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

    }


    /**
     * Hier wird der aktuellen Sitzung die Benutzerfunktion zugeteilt.
     * @param username
     * @param password 
     */
    private void loginAction(String username, String password) {

        if (MyUI.AUTH.authenticate(username, password)) {
            VaadinSession.getCurrent().setAttribute("user", username);
            VaadinSession.getCurrent().setAttribute("userfunction", MyUI.AUTH.getUserfunction());
            Page.getCurrent().setUriFragment("");
            Page.getCurrent().reload();
        } else {
            Notification.show("Ungültige Eingabe", Notification.Type.ERROR_MESSAGE);
        }
    }

}
