package net.devel.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrimeFactorization implements ActionListener{	
	PrimeFactorization()
	{
	}
	
	static void usage() {
		System.out.println("Usage: java MainClass [console|gui]");
		System.out.println("By default you use the console mode");
		System.out.println("If you want graphic mode, use gui parameter.");
		System.out.println("");
	}
	
	static JTextField input=new JTextField(5);
	static JTextField result=new JTextField(5);
	static JButton button=new JButton("submit");
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getActionCommand().equals("submit"))
			result.setText(String.valueOf(primeFactors(Integer.parseInt(input.getText()))));				
	}
	
	static List<Integer> primeFactors(int n){
    	List<Integer> factors=new ArrayList<Integer>();
  		for(int i=2;i<=n;i++)
		{
			while (n%i==0)
			{
				n/=i;
				factors.add(i);
			}
		}
		return factors;
	}
			
	public static void main(String[] args) {
		String runMode="console";
		int n;
		
		JFrame frame=new JFrame("Prime Factorization");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrimeFactorization primeFactorization=new PrimeFactorization();
		JLabel label_input=new JLabel("Enter number:");
		JLabel label_result=new JLabel("Prime factorization:");
		
		if (args.length>0 && (args[0].equals("console") || args[0].equals("gui")))				
				runMode=args[0];

		if (runMode.equals("console"))
				{
			usage();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter number: ");
			n=scanner.nextInt();
			scanner.close();
			System.out.println(primeFactors(n));
				}
		else if (runMode.equals("gui"))
		{
			button.addActionListener(primeFactorization);
			JPanel panel=new JPanel();
			panel.add(label_input);
			panel.add(input);
			panel.add(button);
			panel.add(label_result);
			panel.add(result);
			frame.add(panel);
			frame.setSize(300,200);
			frame.setVisible(true);
			}
	}
}
