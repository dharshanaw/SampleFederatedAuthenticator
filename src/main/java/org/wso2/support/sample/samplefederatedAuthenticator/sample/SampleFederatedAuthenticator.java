package org.wso2.support.sample.samplefederatedAuthenticator.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.authentication.framework.AbstractApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.FederatedApplicationAuthenticator;
import org.wso2.carbon.identity.application.authentication.framework.context.AuthenticationContext;
import org.wso2.carbon.identity.application.authentication.framework.exception.AuthenticationFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public String getFriendlyName() {
        log.info("getFriendlyName");
        return "SampleFederatedAuthenticator";
    }
}
