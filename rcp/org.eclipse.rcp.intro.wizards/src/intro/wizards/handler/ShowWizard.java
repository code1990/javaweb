package intro.wizards.handler;

import intro.wizards.wizard.MyWizard;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowWizard extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		MyWizard wizard = new MyWizard();
		WizardDialog dialog = new WizardDialog(
				HandlerUtil.getActiveShell(event), wizard);
		dialog.open();
		return null;
	}

}
