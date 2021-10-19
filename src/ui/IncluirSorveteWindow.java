package ui;

import domain.Sorvete;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Label;
import totalcross.ui.Window;
import totalcross.ui.dialog.MessageBox;
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
    		} else if (event.target == btInserir) {
    			insertSorvete();
    		}
    		break;
    	default:
    		break;
    	}
    	super.onEvent(event);
    }
    
    
    public void insertSorvete() {
    	String sabor = editSabor.getText();
    	if (sabor.isEmpty()) {
    		new MessageBox("Atenção!", "Digite um sabor!").popup();
    		return;
    	}
    	String valor = editValor.getText();
    	if (valor.isEmpty()) {
    		new MessageBox("Atenção!", "Digite um valor!").popup();
    		return;
    	}
    	String estoque = editEstoque.getText();
    	if (estoque.isEmpty()) {
    		new MessageBox("Atenção!", "Digite um estoque!").popup();
    		return;
    	}
    	
    	double valorAsDouble = 0;
    	double estoqueAsDouble = 0;
    	
    	try {
    		valor = valor.replace(",", ".");
    		valorAsDouble = Double.parseDouble(valor);
    		
    		estoque = valor.replace(",", ".");
    		estoqueAsDouble = Double.parseDouble(estoque);	
    		
    	} catch (Exception e){
    		Vm.debug(e.getMessage());
    		return;
    	}
    	
    	Sorvete sorvete = new Sorvete();
    	sorvete.sabor = sabor;
    	sorvete.valor = valorAsDouble;
    	sorvete.estoque = estoqueAsDouble;
    	
    }
}
