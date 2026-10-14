package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.Book;
import EntityList.BookList;

/*
--- Container----
JFrame --> creates window/frame

--- Components ----
JLabel  --> shows text in frame
JTextField --> takes single line input
JTextArea --> takes multiple line input
JButton --> performs an action

--- AWT ----
Font
Color
*/

public class BookManagementGUI extends JFrame implements ActionListener{
	Font titleFont = new Font("Cambria",Font.BOLD,30);
	Font font15 = new Font("Cambria",Font.BOLD,15);
	
	JTextField idTextField,nameTextField,authorTextField,typeTextField,copyTextField;
	JTextField searchTextField,deleteTextField;
	
	JButton addButton,updateButton,searchButton,deleteButton,clearButton,showAllButton;
	
	JTextArea textArea;
	
	BookList bookList;
	
	public BookManagementGUI(BookList bookList){
		
		//================= Intialization of Frame =================//
		super("Book Management GUI");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(940,650); //width, height
		super.setLocation(150,0); //X, Y
		super.getContentPane().setBackground(new Color(218,232,252));
		super.setLayout(null);
		
		this.bookList = bookList;
		
		
		//================= Frame Components =================//
		//============= Title ===========
		JLabel title = new JLabel("Library Management System");
		title.setBounds(230,10,500,50); //X,Y,W,H
		title.setFont(titleFont);
		//=========== Sub Title ==========
		JLabel subTitle = new JLabel("BOOK INFORMATIONS");
		subTitle.setBounds(300,60,320,50); //X,Y,W,H
		subTitle.setFont(new Font("Cambria",Font.BOLD,25));
		
		
		//////////////////////////////////////////////////////////////////////////////
		//---------------------- LEFT SIDE COMPONENTS ------------------------------//
		//////////////////////////////////////////////////////////////////////////////
		
		//============Book Entry Form ===========
		int top = 100;
		int gap = 40;
		//============Book ID Entry  ===========
		JLabel idLabel = new JLabel("Book ID");
		idLabel.setBounds(20,top,200,30); //X,Y,W,H
		idLabel.setFont(font15);
		
		idTextField = new JTextField();
		idTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		idTextField.setFont(font15);
		
		//============Book Name Entry  ===========
		JLabel nameLabel = new JLabel("Book Name");
		nameLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		nameLabel.setFont(font15);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		nameTextField.setFont(font15);
		
		//============Book Author Entry  ===========
		JLabel authorLabel = new JLabel("Book Author Name");
		authorLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		authorLabel.setFont(font15);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		authorTextField.setFont(font15);
		
		//============Book Type Entry  ===========
		JLabel typeLabel = new JLabel("Book Type");
		typeLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		typeLabel.setFont(font15);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		typeTextField.setFont(font15);
		
		//============Book Copy Entry  ===========
		JLabel copyLabel = new JLabel("Book Copy");
		copyLabel.setBounds(20,top+=gap,200,30); //X,Y,W,H
		copyLabel.setFont(font15);
		
		copyTextField = new JTextField();
		copyTextField.setBounds(20,top+=gap,200,30); //X,Y,W,H
		copyTextField.setFont(font15);
		
		//============Book Entry  Buttons===========
		addButton = new JButton("ADD");
		addButton.setBounds(20,top+=gap+20,200,30); //X,Y,W,H
		addButton.setBackground(Color.GREEN);
		addButton.setFont(font15);
		addButton.addActionListener(this);
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(20,top+=gap,200,30); //X,Y,W,H
		updateButton.setBackground(Color.BLUE);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(font15);
		updateButton.addActionListener(this);
		
		
		//////////////////////////////////////////////////////////////////////////////
		//------------------------ CENTER COMPONENTS -------------------------------//
		//////////////////////////////////////////////////////////////////////////////
		
		//============BOOK INFORMATION DISPLAY  AREA ===========
		textArea = new JTextArea();
		//textArea.setBounds(0,0,460,470);
		textArea.setFont(font15);
		textArea.setEditable(false);
		
		showAllBookInScreen();
				
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(230,120,460,470);
		
		super.add(jsp);
		
		//////////////////////////////////////////////////////////////////////////////
		//--------------------- RIGHT SIDE COMPONENTS ------------------------------//
		//////////////////////////////////////////////////////////////////////////////
		
		top = 100;
		gap = 40;
		//============Book Search Entry  ===========
		JLabel searchLabel = new JLabel("Search By Book ID");
		searchLabel.setBounds(700,top,200,30); //X,Y,W,H
		searchLabel.setFont(font15);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(700,top+=gap,200,30); //X,Y,W,H
		searchTextField.setFont(font15);
		
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(700,top+=gap,200,30); //X,Y,W,H
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);
		
		
		//============Book Delete Entry  ===========
		JLabel deleteLabel = new JLabel("Delete By Book ID");
		deleteLabel.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteLabel.setFont(font15);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteTextField.setFont(font15);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(700,top+=gap,200,30); //X,Y,W,H
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		
		//============ Get All Book Button =============
		showAllButton = new JButton("Show ALL BOOKS");
		showAllButton.setBounds(700,520,200,30); //X,Y,W,H
		showAllButton.setBackground(Color.PINK);
		//showAllButton.setForeground(Color.WHITE);
		showAllButton.setFont(font15);
		showAllButton.addActionListener(this);
		
		//============ Clear Button =============
		clearButton = new JButton("CLEAR SCREEN");
		clearButton.setBounds(700,560,200,30); //X,Y,W,H
		clearButton.setBackground(Color.DARK_GRAY);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(font15);
		clearButton.addActionListener(this);
		
		//================= ADD ALL THE COMPONENTS TO CONTAINER ======================//
		this.add(title);
		this.add(subTitle);
		this.add(idLabel);
		this.add(idTextField);
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(authorLabel);
		this.add(authorTextField);
		this.add(typeLabel);
		this.add(typeTextField);
		this.add(copyLabel);
		this.add(copyTextField);
		this.add(addButton);
		this.add(updateButton);
		this.add(searchLabel);
		this.add(searchTextField);
		this.add(searchButton);
		this.add(deleteLabel);
		this.add(deleteTextField);
		this.add(deleteButton);
		this.add(clearButton);
		this.add(showAllButton);
		//================= DISPLAY THE FRAME ======================//
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		//System.out.println(e.getActionCommand() );
		
		if(e.getActionCommand().equals("ADD")){
			System.out.println("Add Clicked" );
		}
		else if(updateButton == e.getSource()){
			System.out.println("Update Clicked" );
		}
		else if(searchButton == e.getSource()){
			System.out.println("Search Clicked" );
			
			Book b = bookList.getById( searchTextField.getText() );
			if(b!=null){
				textArea.setText( b.getBookInfoAsString() );
			}
			else{
				//textArea.setText( "NO BOOK FOUND\n" );
				JOptionPane.showMessageDialog(this,"NO BOOK FOUND","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(deleteButton == e.getSource()){
			System.out.println("Delete Clicked" );
		}
		else if(showAllButton == e.getSource()){
			showAllBookInScreen();
		}
		else if(clearButton == e.getSource()){
			System.out.println("Clear Clicked" );
			textArea.setText("");
		}
		
	}
	
	public void showAllBookInScreen(){
		textArea.setText(bookList.getAll());
	}
	
}

