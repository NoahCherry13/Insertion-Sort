import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import BreezySwing.*;
public class InsertionGUI extends GBFrame implements KeyListener{

	IntegerField inputFld = addIntegerField(0,1,1,1,1);
	
	public InsertionGUI() {
		inputFld.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		JFrame frm = new InsertionGUI();
		frm.setTitle("Ace Program");
		frm.setSize(700, 500);
		frm.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("Works");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
