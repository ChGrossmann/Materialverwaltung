package ch.teko.pa4.materialverwaltung.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {

    private Label secure = new Label("");
    private Button logout = new Button("Logout");

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

        //Anmeldung
        if (getSession().getAttribute("user") != null) {

            secure.setCaption("Eingeloggter Benutzer: " + VaadinSession.getCurrent().getAttribute("user").toString().toUpperCase());

            logout.addClickListener(new Button.ClickListener() {
                private static final long serialVersionUID = 1L;

                @Override
                public void buttonClick(Button.ClickEvent event) {
                    VaadinSession.getCurrent().setAttribute("user", null);
                    Page.getCurrent().reload();
                }
            });

        } else {
            AUTH = new Authentication();
            VaadinSession.getCurrent().setAttribute("userfunction", "");
            new Navigator(this, this);
            getNavigator().addView(LoginPage.NAME, LoginPage.class);
            getNavigator().setErrorView(LoginPage.class);
        }

        Label titleLab = new Label("Materialverwaltung");
        titleLab.setStyleName("title");
        titleLayout.setSizeFull();
        titleLayout.addComponents(titleLab, secure, logout);
        titleLayout.setComponentAlignment(titleLab, Alignment.TOP_LEFT);
        titleLayout.setComponentAlignment(secure, Alignment.TOP_RIGHT);
        titleLayout.setComponentAlignment(logout, Alignment.BOTTOM_RIGHT);

        TabSheet tabsheet = new TabSheet();
        tabsheet.addTab(new SearchTab().searchTab(), "Suchen");

        if (VaadinSession.getCurrent().getAttribute("userfunction").toString().equals("Admin") ) {
            tabsheet.addTab(new AddTab().addTab(), "Hinzufügen");
        }
        tabsheet.addTab(new PrintTab().printLayout, "Drucken");

        // Hier werden die Erstellten Kompnenten eingefügt.
        rootLayout.addComponents(titleLayout, tabsheet);

        // Setzt den zuvor eingefügten Content
        setContent(rootLayout);
    }
}
