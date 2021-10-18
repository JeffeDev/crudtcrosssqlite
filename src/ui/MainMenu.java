package ui;

import totalcross.ui.Button;
import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;

public class MainMenu extends MainWindow {
	
	private Button btSorvetes;
	

	public MainMenu() {
		btSorvetes = new Button("Sorvetes");
	}
	
	@Override
	public void initUI() {
		add(btSorvetes, LEFT + 10, TOP + 10, FILL - 10, PREFERRED);
	}
	
	@Override
	public void onEvent(Event event) {
		switch (event.type) {
		case ControlEvent.PRESSED:
			if (event.target == btSorvetes) {
				
			}
			break;
		default:
		    break;
		}
		super.onEvent(event);
	}
}
