package org.eclipse.rcp.intro.editor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.rcp.intro.editor.View;
import org.eclipse.rcp.intro.editor.MyPersonEditor;
import org.eclipse.rcp.intro.editor.MyPersonEditorInput;
import org.eclipse.rcp.intro.editor.model.Person;

public class CallEditor extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		View view = (View) page.findView(View.ID);
		ISelection selection = view.getSite().getSelectionProvider()
				.getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (obj != null) {
				Person person = (Person) obj;
				MyPersonEditorInput input = new MyPersonEditorInput(person);
				try {
					page.openEditor(input, MyPersonEditor.ID);
				} catch (PartInitException e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
		return null;
	}

}
