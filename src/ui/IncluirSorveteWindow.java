package ui;

import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.Window;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;

public class IncluirSorveteWindow extends Window {
    private Edit editSabor;
    private Edit editValor;
    private Edit editEstoque;
   
    private Button btInserir;
    private Button btVoltar;
   
    public IncluirSorveteWindow() {
		editSabor = new Edit();
		
		editValor = new Edit("999999999");
		editValor.setMode(Edit.CURRENCY, true);
		editValor.setValidChars("0123456789");
		
		editEstoque = new Edit("999999999");
		editEstoque.setMode(Edit.NORMAL, true);
		editEstoque.setValidChars("0123456789");
		
		btInserir = new Button("Inserir");
		btVoltar = new Button("Voltar");				
    }
    
    @Override
    public void initUI() {
    	add(new Label("Sabor"), LEFT + 10, TOP + 10);
    	add(editSabor, LEFT + 10, AFTER + 5, FILL - 10, PREFERRED);
    	
    	add(new Label("Valor"), LEFT + 10, AFTER + 10);
    	add(editValor, LEFT + 10, AFTER + 5);
    	
    	add(new Label("Estoque"), LEFT + 10, AFTER + 10);
    	add(editEstoque, LEFT + 10, LEFT + 5);
    	
    	add(btInserir, CENTER, AFTER + 20);
    	add(btVoltar, RIGHT -20, BOTTOM -20);
    	
    }
   
    @Override
    public void popup() {
    	setRect(0, 0, Settings.screenWidth, Settings.screenHeight);
    	super.popup();
    }
    
    @Override
    public void onEvent(Event event) {
    	switch(event.type) {
    	case ControlEvent.PRESSED:
    		if (event.target == btVoltar) {
    			this.unpop();
    		}
    		break;
    	default:
    		break;
    	}
    	super.onEvent(event);
    }
}
