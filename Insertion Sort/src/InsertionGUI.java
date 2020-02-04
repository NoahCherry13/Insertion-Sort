import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import BreezySwing.*;
public class InsertionGUI extends GBFrame implements KeyListener{

	String original = ("");
	JLabel inLbl = addLabel ("Enter a Number:",1,1,2,1);
	IntegerField inputFld = addIntegerField(0,2,1,2,1);
	ButtonGroup listOp = new ButtonGroup();
	JRadioButton og = addRadioButton("Show Original",3,1,1,1);
	JRadioButton sorted = addRadioButton("Show Sorted",3,2,1,1);
	JTextArea ListArea = addTextArea("",4,1,2,1);
	
	
	Sort s = new Sort();
	
	public InsertionGUI() {
		listOp.add(og);
		listOp.add(sorted);
		inputFld.addKeyListener(this);
	}
	
	public static void main(String[] args) {
		JFrame frm = new InsertionGUI();
		frm.setTitle("Ace Program");
		frm.setSize(500, 425);
		frm.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			original.concat(inputFld.getNumber()+", ");
			s.addObj(inputFld.getNumber());
			System.out.println(original);
			populate();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void buttonClicked(JButton b) {
		populate();
	}
	
	public void populate() {
		if (og.isSelected()) {
			ListArea.setText(original);
		}else if (sorted.isSelected()) {
			ListArea.setText("");
			for (Object t: s.getSorted()) {
				ListArea.append((int)t+", ");
			}
		}
	}

}
