package org.eclipse.rcp.intro.dialogs.custom.dialogs;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenMyDialog extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		MyDialog dialog = new MyDialog(HandlerUtil.getActiveWorkbenchWindow(
				event).getShell());
		dialog.open();
		return null;
	}

}
