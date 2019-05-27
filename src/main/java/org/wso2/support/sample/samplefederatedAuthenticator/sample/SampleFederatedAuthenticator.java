package org.wso2.support.sample.samplefederatedAuthenticator.sample;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.AbstractApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.FederatedApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.ApplicationAuthenticatorException;
import org.wso2.carbon.identity.application.authentication.framework.exception.AuthenticationFailedException;
import org.wso2.carbon.identity.application.authentication.framework.util.FrameworkConstants;
import org.wso2.carbon.identity.core.util.IdentityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SampleFederatedAuthenticator extends AbstractApplicationAuthenticator implements
        FederatedApplicationAuthenticator {
    private static final Log log = LogFactory.getLog(SampleFederatedAuthenticator.class);

    @Override
    protected void processAuthenticationResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationContext authenticationContext) throws AuthenticationFailedException {
        log.info("getContextIdentifier");
    }

    @Override
    public boolean canHandle(HttpServletRequest httpServletRequest) {

        log.info("processAuthenticationResponse");
        return false;
    }

    @Override
    public String getContextIdentifier(HttpServletRequest httpServletRequest) {
        log.info("getContextIdentifier");
        log.trace("Inside FacebookAuthenticator.getContextIdentifier()");
        String state = httpServletRequest.getParameter("state");
        if (state != null) {
            return state.split(",")[0];
        } else {
            return null;
        }
    }

    @Override
    public String getName() {
        log.info("getName");
        return "SampleFederatedAuthenticator";
    }

    @Override
    protected void initiateAuthenticationRequest(HttpServletRequest request,
                                                 HttpServletResponse response, AuthenticationContext context)
            throws AuthenticationFailedException {


       //try {
            Map<String, String> authenticatorProperties = context.getAuthenticatorProperties();
           String[] qureyParamArray = context.getQueryParams().split("&");
           HashMap<String, String> queryParamMap  = new HashMap<>();
           for (String queryValue:qureyParamArray
                ) {
              String[] queryContent =  queryValue.split("=");
              queryParamMap.put(queryContent[0],queryContent[1]);
           }

           String scope = queryParamMap.get("scope");
           response.setStatus(1);

          // }

           // String authorizationEP = getAuthorizationServerEndpoint();
          //  String scope = authenticatorProperties.get(FacebookCustomAuthenticatorConstants.SCOPE);
//
//            if (StringUtils.isEmpty(scope)) {
//                scope = FacebookCustomAuthenticatorConstants.EMAIL;
//            }
//
//            String callbackUrl = IdentityUtil.getServerURL(FrameworkConstants.COMMONAUTH, true, true);
//
//            String state = context.getContextIdentifier() + "," + FacebookCustomAuthenticatorConstants.FACEBOOK_LOGIN_TYPE;
//
//            OAuthClientRequest authzRequest =
//                    OAuthClientRequest.authorizationLocation(authorizationEP)
//                            .setClientId(clientId)
//                            .setRedirectURI(callbackUrl)
//                            .setResponseType(FacebookCustomAuthenticatorConstants.OAUTH2_GRANT_TYPE_CODE)
//                            .setScope(scope).setState(state)
//                            .buildQueryMessage();
   //        response.sendRedirect(authzRequest.getLocationUri());
//        } catch (IOException e) {
////            log.error("Exception while sending to the login page.", e);
////            throw new AuthenticationFailedException(e.getMessage(), e);
////        } catch (OAuthSystemException e) {
////            log.error("Exception while building authorization code request.", e);
////            throw new AuthenticationFailedException(e.getMessage(), e);
//       }
        return;
    }



    @Override
    public String getFriendlyName() {
        log.info("getFriendlyName");
        return "SampleFederatedAuthenticator";
    }
}
