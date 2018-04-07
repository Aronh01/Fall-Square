
package fallframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FallFrame extends JFrame {

	private JPanel contentPane;
	private SquareComponent squareComponent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FallFrame frame = new FallFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setSizeAndLocalization()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth()/2;
		int height = (int) screenSize.getHeight()/2;
		setBounds(width/2, height/2, width, height);
	}
	
	public FallFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSizeAndLocalization();
		GridBagLayout gridBagLayout = new GridBagLayout();
		//gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		squareComponent=new SquareComponent();
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));		
		contentPane.add(squareComponent);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth=10;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(contentPane, gbc_panel);
		
		JButton btnNewButton = new JButton("Stop");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 7;
		btnNewButton.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        Square.lock();
		    }
		});
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Next Square");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 7;
		btnNewButton_1.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        squareComponent.addSquare();
		    }
		});
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Resume");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 9;
		gbc_btnNewButton_2.gridy = 7;
		btnNewButton_2.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        Square.unLock();
		    }
		});
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);		
		//setContentPane(contentPane);
	}

}
