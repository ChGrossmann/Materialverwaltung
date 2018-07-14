package ch.teko.pa4.materialverwaltung.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        // Das Ausgewählte Layout für die Elemente
        final VerticalLayout rootLayout = new VerticalLayout();
        
        final HorizontalLayout titleLayout = new HorizontalLayout();
        
        Label titelLab = new Label("Materialverwaltung");
        
        Button loginBtn = new Button("Login");
        
        titleLayout.addComponents(titelLab, loginBtn);
        
        
        TabSheet tabsheet = new TabSheet();
        
        
        
        tabsheet.addTab(new SearchTab().searchTab(), "Search");
        tabsheet.addTab(new AddTab().addTab(), "Add");
        tabsheet.addTab(new DeleteTab().deleteLayout, "Delete");
        tabsheet.addTab(new PrintTab().printLayout, "Print");
        
        
       
        
        // Hier werden die Erstellten Kompnenten eingefügt.
        rootLayout.addComponents(titleLayout, tabsheet);
        
        
        // Setzt den zuvor eingefügten Content
        setContent(rootLayout);
    }

    
    
    
    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
