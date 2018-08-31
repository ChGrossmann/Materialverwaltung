package ch.teko.pa4.materialverwaltung.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
//@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {

    private Label secure;
    private Button logout;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyUI.class)
    public static class Servlet extends VaadinServlet {
    }

    public static Authentication AUTH;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        // Das Ausgewählte Layout für die Elemente
        final VerticalLayout rootLayout = new VerticalLayout();
        final HorizontalLayout titleLayout = new HorizontalLayout();

        Label titelLab = new Label("Materialverwaltung");

        titleLayout.addComponents(titelLab);

        TabSheet tabsheet = new TabSheet();

        //Anmeldung
        if (getSession().getAttribute("user") != null) {
            secure = new Label("");
            secure.setCaption("Eingeloggter Benutzer: " + VaadinSession.getCurrent().getAttribute("user").toString());

            rootLayout.addComponents(titleLayout, secure);

            logout = new Button("Ausloggen");
            logout.addClickListener(new Button.ClickListener() {
                private static final long serialVersionUID = 1L;

                @Override
                public void buttonClick(Button.ClickEvent event) {
                    //getUI().getNavigator().removeView(SecurePage.NAME);
                    VaadinSession.getCurrent().setAttribute("user", null);
                    Page.getCurrent().reload();
                }
            });
            rootLayout.addComponents(titleLayout, logout);

        } else {
            AUTH = new Authentication();
            new Navigator(this, this);
            getNavigator().addView(LoginPage.NAME, LoginPage.class);
            getNavigator().setErrorView(LoginPage.class);
        }

        tabsheet.addTab(new SearchTab().searchTab(), "Suchen");
        tabsheet.addTab(new AddTab().addTab(), "Hinzufügen");
        tabsheet.addTab(new EditTab().editTab(), "Ändern");
        tabsheet.addTab(new DeleteTab().deleteTab(), "Löschen");
        tabsheet.addTab(new PrintTab().printLayout, "Drucken");

        // Hier werden die Erstellten Kompnenten eingefügt.
        rootLayout.addComponents(titleLayout, tabsheet);

        // Setzt den zuvor eingefügten Content
        setContent(rootLayout);
    }
}
