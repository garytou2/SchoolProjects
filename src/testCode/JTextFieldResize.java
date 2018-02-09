package testCode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.FontMetrics;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JTextFieldResize {
	public static void main(String[] args) {
		create();
		interaction();
	}

	static JFrame frame = new JFrame();
	static JSplitPane split = new JSplitPane();
	static JTextField field = new JTextField();
	static JPanel fontPane = new JPanel();
	static JButton small = new JButton();
	static JSlider slider = new JSlider();
	static JButton big = new JButton();

	static Font defaultFont = mainProgram.RL.scan;
	static Font currentFont = defaultFont;
	static float fontSize = 20f;
	
	static double prevFieldHeight = field.getSize().getHeight();
	static double currFieldHeight = field.getSize().getHeight();

	public static void changeByButton(int difference) { //resize field to fit font
		field.setFont(currentFont);
		field.setSize(new Dimension(field.getWidth(), field.getHeight() + difference));
		split.setDividerLocation(-1);
		//change majorLR
		
	}
	public static void changeBySplit(double clicks) { //resize font to fit field
		double change = clicks*2.5;
		fontSize += change;
		fontSize = Math.min(fontSize, mainProgram.config.maxFontSize);
		fontSize = Math.max(fontSize, mainProgram.config.minFontSize);
		currentFont = defaultFont.deriveFont(fontSize);
		field.setFont(currentFont);
		field.setSize(field.getPreferredSize());
		split.setDividerLocation(-1);
	}
	
	
	
	// no need to touch these methods
	public static void create() {
		split.setOrientation(JSplitPane.VERTICAL_SPLIT);

		frame.add(split);

		split.setTopComponent(field);
		split.setBottomComponent(fontPane);
		split.setDividerSize(0);
		
		
		fontPane.setLayout(new BorderLayout());
		fontPane.add(small, BorderLayout.LINE_START);
		fontPane.add(slider, BorderLayout.CENTER);
		fontPane.add(big, BorderLayout.LINE_END);
		
		small.setText("<");
		big.setText(">");
		slider.setMinimum(8);
		slider.setMaximum(500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(frame.getWidth(), frame.getHeight() + 50);
		frame.setVisible(true);

	}

	public static void interaction() {
		small.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontSize--;
				currentFont = defaultFont.deriveFont(fontSize);
				slider.setValue((int) fontSize);
				changeByButton(-1);
			}
		});
		big.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontSize++;
				currentFont = defaultFont.deriveFont(fontSize);
				slider.setValue((int) fontSize);
				changeByButton(1);
			}
		});
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				fontSize = slider.getValue();
				currentFont = defaultFont.deriveFont(fontSize);
				field.setFont(currentFont);
				split.setDividerLocation(-1);
			}
		});
		field.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyChar() == KeyEvent.VK_ENTER) {
					System.out.println(field.getText());
					field.setText("");
				}

			}
		});
		/*split.addMouseListener(new MouseListener() { //mouse press
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {
				prevFieldHeight = field.getSize().getHeight();
			}
			
		});
		split.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new PropertyChangeListener() { //mouse release
			public void propertyChange(PropertyChangeEvent evt) {
				currFieldHeight = field.getSize().getHeight();
				changeBySplit();
			}
		});*/
		
		split.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent mwe) {
				changeBySplit(mwe.getPreciseWheelRotation());
				System.out.println(mwe.getPreciseWheelRotation());
			}
			
		});
	}
}
