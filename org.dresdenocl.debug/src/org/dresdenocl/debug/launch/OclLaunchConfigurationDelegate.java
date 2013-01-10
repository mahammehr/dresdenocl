package org.dresdenocl.debug.launch;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import org.dresdenocl.debug.OclDebugPlugin;
import org.dresdenocl.debug.model.OclDebugProcess;
import org.dresdenocl.debug.model.OclDebugTarget;
import org.dresdenocl.model.IModel;
import org.dresdenocl.model.ModelAccessException;
import org.dresdenocl.modelbus.ModelBusPlugin;
import org.dresdenocl.modelinstance.IModelInstance;
import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.pivotmodel.Constraint;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

public class OclLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		int requestPort = -1;
		int eventPort = -1;

		// Check preconditions
		IModel model;
		IModelInstance minstance;
		List<IModelInstanceElement> miElements;
		List<Constraint> constraints = null;

		model = ModelBusPlugin.getModelRegistry().getActiveModel();
		if (model == null) {
			abort("No active model found.", null);
		}

		minstance =
				ModelBusPlugin.getModelInstanceRegistry().getActiveModelInstance(model);
		if (minstance == null) {
			abort(String.format("No active modelinstance found for {0}", model), null);
		}

		miElements =
				new ArrayList<IModelInstanceElement>(
						minstance.getAllModelInstanceObjects());
		if (miElements.size() == 0) {
			abort(String.format("There are no modelinstance elements for {0}",
					minstance), null);
		}

		try {
			constraints = new ArrayList<Constraint>(model.getConstraints());
		} catch (ModelAccessException e) {
			abort("Cannot access model", e);
		}
		if (constraints == null || constraints.size() == 0) {
			abort("There are no constraints to evaluate", null);
		}

		// Check for the mode
		if (mode.equals(ILaunchManager.DEBUG_MODE)) {
			requestPort = findFreePort();
			eventPort = findFreePort();
			if (requestPort == -1 || eventPort == -1) {
				// unable to find free port, abort
				abort("Unable to find free port.", null);
			}
			// TODO Lars
			// 1. run the interpreter in debug mode in own thread
			Thread interpreterThread = new Thread(new Runnable() {

				@Override
				public void run() {
					
				}
			});
			interpreterThread.start();
			// 2. make debug listener attach to debugger
			// (this is done by the OclDebugTarget in the current implementation)
			// 3. start debugger
			OclDebugProcess process = new OclDebugProcess(launch);
			OclDebugTarget target =
					new OclDebugTarget(launch, process, requestPort, eventPort);
			launch.addDebugTarget(target);
		}
		else if (mode.equals(ILaunchManager.RUN_MODE)) {
			// run the interpreter in normal launch mode
			// IDebugTarget target = null;
			// TODO Lars: Initialize target
			// launch.addDebugTarget(target);
		}
		else {
			// Nothing has been applied
			abort(String.format("Do not know what to do with {0}", mode), null);
		}
	}

	private void abort(final String message, final Throwable e)
			throws CoreException {

		throw new CoreException(new Status(IStatus.ERROR, OclDebugPlugin.PLUGIN_ID,
				message, e));
	}

	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free
	 * port.
	 * 
	 * @return a free port number on localhost, or -1 if unable to find a free
	 *         port
	 */
	public static int findFreePort() {

		ServerSocket socket = null;
		try {
			socket = new ServerSocket(0);
			return socket.getLocalPort();
		} catch (IOException e) {
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		return -1;
	}
}
