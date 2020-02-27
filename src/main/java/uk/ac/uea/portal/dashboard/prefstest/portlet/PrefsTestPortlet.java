package uk.ac.uea.portal.dashboard.prefstest.portlet;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import uk.ac.uea.portal.dashboard.prefstest.configuration.PrefsTestConfiguration;
//import aQute.bnd.annotation.metatype.Configurable;

/**
 * (1)configurationPid represents the configuration for this portlet class
 */
@Component(
		configurationPid = "uk.ac.uea.portal.dashboard.prefstest.configuration.PrefsTestConfiguration",
		immediate = true, property = {
		"com.liferay.portlet.display-category=Pro Liferay", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Configuration Demo Portlet", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PrefsTestPortlet extends MVCPortlet {
	
	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		/**
		 renderRequest.setAttribute(
				 DemoConfiguration.class.getName(),
				 _demoConfiguration);
		*/

		/**
		 * Configuration can be directly set in the control panel of liferay 
		 * We can access those here 
		 */


		_log.info("#########City##########"+_prefsTestConfiguration.city()); 
		_log.info("#########Unit##########"+_prefsTestConfiguration.temperatureUnit());
		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * 
	 * (1)If a method is annoted with @Activate then the method will be called at the time of activation of the component
	 *  so that we can perform initialization task
	 *  
	 * (2) This class is annoted with @Component where we have used configurationPid with id com.proliferay.configuration.DemoConfiguration
	 * So if we modify any configuration then this method will be called. 
	 */
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_log.info("#####Calling activate() method######");
		
		_prefsTestConfiguration = ConfigurableUtil.createConfigurable(PrefsTestConfiguration.class, properties);
		//_demoConfiguration = ConfigurableUtil.createConfigurable(DemoConfiguration.class, properties);
		
	}

	private static final Log _log = LogFactoryUtil.getLog(PrefsTestPortlet.class);

	private volatile PrefsTestConfiguration _prefsTestConfiguration;  

}