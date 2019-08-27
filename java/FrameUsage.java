/* Create an empty window.*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import statements
//Check if window closes automatically. Otherwise add suitable code
public class FrameUsage {

	public static void main(String args[]) {
		JFrame frame = new JFrame("JFrame Demo");
		frame.addWindowListener(new WindowAdapter() {
		    public void WindowClosing(WindowEvent e) {
		        System.exit(0);
		    }
		});

		JLabel label1 = new JLabel("");
		label1.setPreferredSize(new Dimension(175, 100));
		frame.getContentPane().add(label1, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

}
