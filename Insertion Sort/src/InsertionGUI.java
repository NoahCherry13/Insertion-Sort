import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

import java.awt.Color;
import java.awt.color.*;
public class InsertionGUI extends GBFrame implements KeyListener,ItemListener{

	public String original = ("1");
	private int count = 0;
	JLabel inLbl = addLabel ("Enter a Number:",1,1,2,1);
	IntegerField inputFld = addIntegerField(0,2,1,2,1);
	ButtonGroup listOp = new ButtonGroup();
	JRadioButton og = addRadioButton("Show Original",3,1,1,1);
	JRadioButton sorted = addRadioButton("Show Sorted",3,2,1,1);
	JTextArea ListArea = addTextArea("",4,1,2,1);
	ArrayList <Integer> unsorted = new ArrayList<Integer>();
	JMenuItem meanMI = addMenuItem("Compute","Mean");
	JMenuItem medianMI = addMenuItem("Compute","Median");
	JMenuItem modeMI = addMenuItem("Compute","Mode");
	JMenuItem stdMI = addMenuItem("Compute","Standard Deviation");
	
	Sort s = new Sort();
	
	public InsertionGUI() {

		og.setSelected(true);
		inputFld.selectAll();
		listOp.add(og);
		listOp.add(sorted);
		inputFld.addKeyListener(this);
		og.addItemListener(this);
		sorted.addItemListener(this);
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
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			count ++;
			if (count>25) {
				messageBox("You can not enter more than 25 numbers");
				return;
			}
			inputFld.requestFocus();
			inputFld.selectAll();
			unsorted.add(inputFld.getNumber());
			s.addObj(inputFld.getNumber());
			populate();
		}
		
	}
	
	public void menuItemSelected(JMenuItem mi) {
		if (mi == modeMI) {
			String str = "";
			try {
				s.mode();
			
			for (int i = 0; i < s.getModeList().size(); i ++) {
				str+=((int)s.getModeList().get(i)+", ");
			}
			messageBox("The mode is: "+ str);
			str = "";
			} catch (InvalidModeException e) {
				// TODO Auto-generated catch block
				messageBox(e.getMessage());
			}
		}else if (mi == meanMI) {
			messageBox("The Mean is: "+ s.mean());
		}else if (mi == medianMI) {
			messageBox("The Median is: "+ s.median());
		}else if (mi == stdMI) {
			messageBox("The Standard Deviation is: "+ s.SD());
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
			ListArea.setText("");
			for (Integer i: unsorted) {
				ListArea.append((int)i+", ");
			}
		}else if (sorted.isSelected()) {
			ListArea.setText("");
			for (Object t: s.getSorted()) {
				ListArea.append((int)t+", ");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (og.isSelected()) {
				populate();
			} else if (sorted.isSelected()) {
				populate();
			}
		}

	}

}
