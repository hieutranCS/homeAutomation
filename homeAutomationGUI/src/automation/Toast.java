package automation;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Toast extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Toast frame = new Toast();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Toast() {
    	
    	 String[] hotness = {"Mildly Hot", "Hot", "Super Hot"};//
         JComboBox select = new JComboBox(hotness);
         JLabel label = new JLabel();
         
         select.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent e)
        	 {
        		 JComboBox comb = (JComboBox)e.getSource();
        		 String app = (String) select.getSelectedItem();
        		 
        		switch(app)
        		{
        			case "Mildly Hot": label.setText("Set to \"Mildly Hot\". Press \"Toast\"");
        				break;
        				
        			case "Hot": label.setText("Set to \"Hot\". Press \"Toast\"");
        				break;
        				
        			case "Super Hot": label.setText("Set to \"Super Hot\". Press \"Toast\"");
        				break;
        			
        			default: label.setText("There was an error.");
        		}
        	 }
         });
    	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(250, 250, 250, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(select);
        setContentPane(contentPane);
        
        
        

        JButton btnTestToast = new JButton("Toast");
        btnTestToast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ToastMessage toastMessage = new ToastMessage("Now Toasting ",3000);
                toastMessage.setVisible(true);
            }
        });
        contentPane.add(btnTestToast, BorderLayout.SOUTH);
        contentPane.add(select, BorderLayout.NORTH);
        contentPane.add(label);
    }

}

