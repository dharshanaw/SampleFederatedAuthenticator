package org.wso2.support.sample.samplefederatedAuthenticator.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.identity.application.authentication.framework.ApplicationAuthenticator;
import org.wso2.support.sample.samplefederatedAuthenticator.sample.SampleFederatedAuthenticator;

import java.util.Hashtable;

/**
 * @scr.component name="identity.application.authenticator.facebook.component"
 *                immediate="true"
 */
public class SampleFederatedAuthenticatorServiceComponent {

    private static final Log LOGGER = LogFactory.getLog(SampleFederatedAuthenticatorServiceComponent.class);

    protected void activate(ComponentContext ctxt) {
        try {
            SampleFederatedAuthenticator sampleFederatedAuthenticator = new SampleFederatedAuthenticator();
            Hashtable<String, String> props = new Hashtable<String, String>();

            ctxt.getBundleContext().registerService(ApplicationAuthenticator.class.getName(),
                    sampleFederatedAuthenticator, props);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("sampleFederatedAuthenticator Custome Authenticator bundle is activated");
            }
        } catch (Throwable e) {
            LOGGER.fatal(" Error while activating sampleFederatedAuthenticator authenticator ", e);
        }
    }

    protected void deactivate(ComponentContext ctxt) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("sampleFederatedAuthenticator Custom Authenticator bundle is deactivated");
        }
    }
}
