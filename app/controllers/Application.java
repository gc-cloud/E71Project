package controllers;

import be.objectify.deadbolt.java.actions.SubjectPresent;
import com.google.inject.Inject;
import models.JsonContent;
import modules.SecurityModule;
import org.pac4j.core.client.Client;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.core.context.Pac4jConstants;
import org.pac4j.core.exception.HttpAction;
import org.pac4j.core.exception.TechnicalException;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.http.client.indirect.FormClient;
import org.pac4j.jwt.profile.JwtGenerator;
import org.pac4j.play.PlayWebContext;
import org.pac4j.play.java.Secure;
import org.pac4j.play.store.PlaySessionStore;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Content;

import java.util.List;

public class Application extends Controller {

    @Inject
    private Config config;

    @Inject
    private PlaySessionStore playSessionStore;

    public List<CommonProfile> getProfiles() {
        final PlayWebContext context = new PlayWebContext(ctx(), playSessionStore);
        final ProfileManager<CommonProfile> profileManager = new ProfileManager(context);
        return profileManager.getAll(true);
    }

    @Secure(clients = "AnonymousClient", authorizers = "csrfToken")
    public Result index() throws Exception {
        final PlayWebContext context = new PlayWebContext(ctx(), playSessionStore);
        final String token = (String) context.getRequestAttribute(Pac4jConstants.CSRF_TOKEN);
        // profiles (maybe be empty if not authenticated)
//        return ok(views.html.index.render(getProfiles(), token));
        return ok(views.html.index.render());
    }

    private Result protectedIndexView() {
        // profiles
        getProfiles();
        return ok(views.html.index.render());
//        return ok(views.html.protectedIndex.render(getProfiles()));
    }

    //@Secure(clients = "FacebookClient")
    public Result facebookIndex() {
        return protectedIndexView();
    }

    @Secure(clients = "FacebookClient", authorizers = "admin")
    public Result facebookAdminIndex() {
        return protectedIndexView();
    }

    @Secure(clients = "FacebookClient", authorizers = "custom")
    public Result facebookCustomIndex() {
        return protectedIndexView();
    }

    @Secure(clients = "TwitterClient,FacebookClient")
    public Result twitterIndex() {
        return protectedIndexView();
    }

    @Secure
    public Result protectedIndex() {
        return protectedIndexView();
    }

    //@Secure(clients = "FormClient")
    @SubjectPresent(handlerKey = "FormClient", forceBeforeAuthCheck = true)
    public Result formIndex() {
        return protectedIndexView();
    }

    // Setting the isAjax parameter is no longer necessary as AJAX requests are automatically detected:
    // a 401 error response will be returned instead of a redirection to the login url.
    @Secure(clients = "FormClient")
    public Result formIndexJson() {
        Content content = views.html.protectedIndex.render(getProfiles());
        JsonContent jsonContent = new JsonContent(content.body());
        return ok(jsonContent);
    }

    @Secure(clients = "IndirectBasicAuthClient")
    public Result basicauthIndex() {
        return protectedIndexView();
    }

    @Secure(clients = "DirectBasicAuthClient,ParameterClient")
    public Result dbaIndex() {
        return protectedIndexView();
    }

    @Secure(clients = "CasClient")
    public Result casIndex() {
        /*final CommonProfile profile = getProfiles().get(0);
        final String service = "http://localhost:8080/proxiedService";
        String proxyTicket = null;
        if (profile instanceof CasProxyProfile) {
            final CasProxyProfile proxyProfile = (CasProxyProfile) profile;
            proxyTicket = proxyProfile.getProxyTicketFor(service);
        }
        return ok(views.html.casProtectedIndex.render(profile, service, proxyTicket));*/
        return protectedIndexView();
    }

    @Secure(clients = "SAML2Client")
    public Result samlIndex() {
        return protectedIndexView();
    }

    @Secure(clients = "OidcClient")
    public Result oidcIndex() {
        return protectedIndexView();
    }

    //@Secure(clients = "ParameterClient")
    public Result restJwtIndex() {
        return protectedIndexView();
    }

    //@Secure(clients = "AnonymousClient", authorizers = "csrfCheck")
    public Result csrfIndex() {
        return ok(views.html.csrf.render(getProfiles()));
    }

    public Result jwt() {
        final List<CommonProfile> profiles = getProfiles();
        final JwtGenerator generator = new JwtGenerator(SecurityModule.JWT_SALT);
        String token = "";
        if (CommonHelper.isNotEmpty(profiles)) {
            token = generator.generate(profiles.get(0));
        }
        return ok(views.html.jwt.render(token));
    }

    public Result forceLogin() {
        final PlayWebContext context = new PlayWebContext(ctx(), playSessionStore);
        final Client client = config.getClients().findClient(context.getRequestParameter(Clients.DEFAULT_CLIENT_NAME_PARAMETER));
        try {
            final HttpAction action = client.redirect(context);
            return (Result) config.getHttpActionAdapter().adapt(action.getCode(), context);
        } catch (final HttpAction e) {
            throw new TechnicalException(e);
        }
    }
}
