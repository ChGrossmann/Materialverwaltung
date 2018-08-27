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

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = Login.class)
    public static class Servlet extends VaadinServlet {
    }

    public static Authentication AUTH;

    private void router(String route) {
        Notification.show(route);
        if (getSession().getAttribute("user") != null) {
            getNavigator().addView(SecurePage.NAME, SecurePage.class);
            getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
            if (route.equals("!OtherSecure")) {
                getNavigator().navigateTo(OtherSecurePage.NAME);
            } else {
                getNavigator().navigateTo(SecurePage.NAME);
            }
        } else {
            getNavigator().navigateTo(LoginPage.NAME);
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        AUTH = new Authentication();
        new Navigator(this, this);

        getNavigator().addView(LoginPage.NAME, LoginPage.class);
        getNavigator().setErrorView(LoginPage.class);

        Page.getCurrent().addUriFragmentChangedListener(new Page.UriFragmentChangedListener() {

            @Override
            public void uriFragmentChanged(Page.UriFragmentChangedEvent event) {
                router(event.getUriFragment());
            }
        });

        router("");
        // Das Ausgewählte Layout für die Elemente
        final VerticalLayout rootLayout = new VerticalLayout();

        final HorizontalLayout titleLayout = new HorizontalLayout();

        Label titelLab = new Label("Materialverwaltung");

        //Button loginBtn = new Button("Login");
        titleLayout.addComponents(titelLab);

        TabSheet tabsheet = new TabSheet();

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

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
