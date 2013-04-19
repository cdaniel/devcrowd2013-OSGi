package devcrowd;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import devcrowd.api.PreferenceService;
import devcrowd.impl.PreferenceServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<?> registeredService;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		registeredService = bundleContext.registerService(PreferenceService.class.getName(), new PreferenceServiceImpl(), null);
		System.out.println("Service registered");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		registeredService.unregister();
		System.out.println("Service unregistered");
	}

}
