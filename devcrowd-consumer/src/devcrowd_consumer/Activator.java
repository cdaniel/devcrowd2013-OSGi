package devcrowd_consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import devcrowd.api.PreferenceService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	volatile boolean stopped = false;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		final ServiceTracker tracker = new ServiceTracker<>(bundleContext, PreferenceService.class.getName(), null);
		
		tracker.open();
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (!stopped) {
					PreferenceService service = (PreferenceService) tracker
							.getService();
					if (service != null) {
						service.setPreference("time", "16.01");
					} else {
						System.out.println("No service");
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		stopped = true;
	}

}
