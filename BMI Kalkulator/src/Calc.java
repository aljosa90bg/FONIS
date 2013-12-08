import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Calc {

	protected Shell shell;
	private Text visina;
	private Text tezina;
	private Text rezultat;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calc window = new Calc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(495, 346);
		shell.setText("Kalkulator");
		
		Label lblPrviBroj = new Label(shell, SWT.NONE);
		lblPrviBroj.setBounds(35, 99, 55, 15);
		lblPrviBroj.setText("Prvi broj");
		
		visina = new Text(shell, SWT.BORDER);
		visina.setBounds(35, 120, 75, 25);
		
		Label lblDrugiBroj = new Label(shell, SWT.NONE);
		lblDrugiBroj.setBounds(35, 162, 55, 15);
		lblDrugiBroj.setText("Drugi broj");
		
		tezina = new Text(shell, SWT.BORDER);
		tezina.setBounds(35, 183, 75, 25);
		
		Button saberi = new Button(shell, SWT.NONE);
		saberi.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int prviBroj, drugiBroj;
				try{
					prviBroj = Integer.parseInt(visina.getText());
					
				} catch (Exception exc){
					MessageDialog.openError( shell, "Greska!", "Los prvi boj!");
					return;
				}
			
				try{
					drugiBroj = Integer.parseInt(tezina.getText());
					
				} catch (Exception exc){
					MessageDialog.openError( shell, "Greska!", "Los drugi boj!");
					return;
				}
			
				int odg = prviBroj + drugiBroj;
				
				rezultat.setText(String.valueOf(odg));
			}
			
		
		
		});
		saberi.setToolTipText("Saberi");
		saberi.setBounds(323, 156, 75, 75);
		saberi.setText("+");
		
		Label lblOdgovor = new Label(shell, SWT.NONE);
		lblOdgovor.setAlignment(SWT.CENTER);
		lblOdgovor.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblOdgovor.setBounds(267, 45, 184, 44);
		lblOdgovor.setText("Odgovor je:");
		
		rezultat = new Text(shell, SWT.BORDER);
		rezultat.setBounds(267, 101, 184, 25);

	}
}
