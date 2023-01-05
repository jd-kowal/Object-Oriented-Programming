import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyFirstCalculatorv5 {

    public static void createAndShowGUI() {
        JFrame jf = new JFrame("My First Frame");
        jf.setSize(305,260);	//set size of the frame
        jf.setLocationRelativeTo(null);	//location centered on screen
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//closes aplication when the calculator closes
        jf.setResizable(false);	//user cannot resize the frame      
        
        JPanel jp = new JPanel(); 
        jf.getContentPane().add(jp);
        jp.setLayout(new FlowLayout(FlowLayout.CENTER,20,25));

        
        JTextField textField = new JTextField("0");
        textField.setFont(new Font("Arial",Font.BOLD,20));
		textField.setEditable(false);	//text field is set false to not be editable by user
		textField.setHorizontalAlignment(SwingConstants.RIGHT);	//text is glued to the right side of window
		jf.getContentPane().add(textField, BorderLayout.NORTH);	//text filed is located in the NORTH of the frame
        //jp.add(textField);
        
        
        
        ActionListener myActionListener = new ActionListener() {
        	
        	/** this method checks if user is divides by 0 */
        	private String checkinZerosInResults(String input) {
        		return input == "Err divided by 0" ? input : rounding(input);
            }
        	
        	/** method rounding parse Double on Long type */
        	private String rounding(String input) {
        		if (input.isEmpty())
                    return "";
        		return Double.parseDouble(input) < 0 ? String.valueOf((long) (Double.parseDouble(input) - 0.5)) : String.valueOf((long) (Double.parseDouble(input) + 0.5));
        	}

        	/** howCalcWorks is a method that performs mathematical operations on inputs */
            private String howCalcWorks(String a, String b, String symbol) {
            	if (a.equals("") && b.equals("")) {
                    return "0";
                }
                if (b.equals("")) {
                    return a;
                }
                if (a.equals("")) {		// * 0 ?
                    return b;
                }
                if (symbol == "/" & Double.parseDouble(a) == 0) {
                	System.err.println("You can not divide by ZERO !!!");
                    return "Err divided by 0";
                }
                switch (symbol) {
                    case "+":
                        return String.valueOf(Double.parseDouble(b) + Double.parseDouble(a));
                    case "-":
                        return String.valueOf(Double.parseDouble(b) - Double.parseDouble(a));
                    case "*":
                        return String.valueOf(Double.parseDouble(b) * Double.parseDouble(a));
                    case "/":
                        return String.valueOf(Double.parseDouble(b) / Double.parseDouble(a));
                    default:
                        return a;
                }
            }

            String input = "0";		//0 wyświetlane na początku lub po C (po error)
            String previousInput = "";
            final String symbols = "+-*/=C";	//values u can't change
            String currentSymbol = "";	//default symbol
            boolean ifLastEquals = false;
            final private String formatString = "%40s";	//way strings are formatting

            public void actionPerformed(ActionEvent e) {
            	String accInput = e.getActionCommand();
                System.out.println("Button = " + accInput);
                if (!symbols.contains(accInput)) {
	                if (ifLastEquals) {
	                    input = "";
	                    previousInput = "";
	                    currentSymbol = "";
	                    ifLastEquals = false;
	                }
	                input += accInput;
	                input = String.format(formatString, checkinZerosInResults(input));
	                textField.setText(input);
	            } else {
                    if (accInput.equals("C")) {
                        input = "0";
                        previousInput = "";
                        currentSymbol = "";
                        ifLastEquals = false;
                        input = String.format(formatString, input);
                        textField.setText(input);
                    } else {
                    	if (input.equals("") && accInput.equals("=") && !currentSymbol.equals("")) {
                            input = previousInput;
                    	}else if (ifLastEquals && !accInput.equals("=")) {
                            currentSymbol = "";
                            ifLastEquals = false;
                            input = "";
                        }
                        /*if (ifLastEquals && !accInput.equals("=")) {
                            currentSymbol = "";
                            ifLastEquals = false;
                            input = "";
                        } else if (input.equals("") && accInput.equals("=") && !currentSymbol.equals("")) {
                            input = previousInput;
                        }*/
                        previousInput = String.format(formatString, checkinZerosInResults(howCalcWorks(input, previousInput, currentSymbol)));
                        textField.setText(previousInput);
                        if (accInput.equals("=")) {
                            ifLastEquals = true;
                        } else {
                            currentSymbol = accInput;
                            input = "";
                        }
                        if (previousInput.equals(String.format(formatString,"Err divided by 0"))){
                            input = "0";
                            previousInput = "";
                            currentSymbol = "";
                            ifLastEquals = false;
                        }
                    }
	            }
                    
                System.out.println("a: " + rounding(input) + "  b: " + rounding(previousInput) + "  symbol: " + currentSymbol);

            }
        };
    	
    	
        String[] butons = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};
        for (String i : butons) {
        	JButton x = new JButton(i);
            x.addActionListener(myActionListener);
            x.setFont(new Font("Arial",Font.BOLD,20));
            x.setPreferredSize(new Dimension(50,20));
            jp.add(x);
        }
    	
    	
        //jf.pack(); // all mieści się w ramce - automatycznie ustawia ramkę
        //jf.setVisible(true);
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kończy działanie aplikacji wraz z zamknięciem okienka
    }

	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }

}