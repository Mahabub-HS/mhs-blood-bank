package bd.edu.seu.frontend.UserView;

import bd.edu.seu.frontend.AdminView.*;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
public class UserMainView extends AppLayout {

    public UserMainView() {
        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        RouterLink routerLink = new RouterLink("Notice", NoticeView.class);
        routerLink.setHighlightCondition(HighlightConditions.sameLocation());
        addToDrawer(
                new VerticalLayout(
                        routerLink,
                        new RouterLink("Dash Board", DashBordUser.class),
                        new RouterLink("Request ", RequestView.class)

                )
        );
    }

    private void createHeader() {
        H1 logo = new H1("MHS Blood Bank Management System(User Panel)");
        logo.addClassName("logo");
        Anchor anchor = new Anchor("login","Log Out");
        HorizontalLayout horizontalLayout = new HorizontalLayout(new DrawerToggle(),logo,anchor);
        horizontalLayout.expand(logo);
        horizontalLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        horizontalLayout.setWidth("100%");
        horizontalLayout.addClassName("header");
        addToNavbar(horizontalLayout);
    }
}
