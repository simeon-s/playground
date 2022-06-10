import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import Movie.Film;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

//Function for adding movies to the array of objects

public class MainFrame extends JFrame {

  private JPanel contentPane;
  private JTextField inputID;
  private JTextField inputName;
  private JTextField inputDirector;
  private JTextField inputYear;
  private JTextField sID;
  private JTextField sName;
  private JTextField sDirector;
  private JTextField sYear;
  private JTextField sGenre;
  private JTextField sIDSearch;

  /**
   * Launch the application.
   */

  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainFrame frame = new MainFrame();
          frame.setVisible(true);
          frame.setResizable(false);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  static Film[] obj = new Film[100];
  static ButtonGroup group = new ButtonGroup();
  static String messageForLog = "";

  static int filmCounter = 0;
  static String logText = " ";
  public static void printAll() {
    for (int i = 1; i < filmCounter; i++) {
      obj[i].showData();
    }
  }

  // Function for adding movies to the array of objects
  public static void addFilm(String ID, String title, String director, String genre, int year) {
    obj[filmCounter] = new Film();
    int flagFound = 0;
    for (int i = 1; i < filmCounter; i++) {
      System.out.println("current id" + obj[i].ID);
      if (obj[i].ID.equals(ID)) {
        System.out.println("Duplicate");
        messageForLog = "A movie with " + ID + "is not added. Duplicate already exist!";

        flagFound = 1;
      }
    }
    if (flagFound == 0) {
      obj[filmCounter].setData(ID, title, director, genre, year);
      filmCounter++;
    }

  }
  // Check if a movie already exists with the same ID 
  public static int searchForDuplicates(String ID) {
    System.out.println("SD");

    for (int i = 0; i < filmCounter; i++) {
      System.out.println("ID:" + obj[i].ID);

      if (obj[i].ID == ID) {
        System.out.println("Duplicate");

        return 1; // There is a duplicate

      }
    }
    return 0;

  }

  //	public static String getGenre()
  //	{
  //		String SelectedItem;
  ////		for ( JCheckBox checkbox : group ) {
  ////		    if( checkbox.isSelected() )
  ////		    {
  ////		        SelectedItem += btn.getText() + ",";
  ////		    }
  ////		}
  //		foreach (Button btn in group.Controls.OfType<Button>())
  //		{
  //		    if (btn.Text == textBox1.Text)
  //		        btn.Enabled = false;
  //		}
  //	}

  /**
   * Create the frame.
   */
  public MainFrame() {

    setTitle("Movie base");

    addFilm("0001", "Fast and Furious", "Justin Lin", "Action", 2001);
    //addFilm("0001", "Fast and Furious 2", "Justin Lin", "Action", 2003);
    addFilm("0002", "The Shawshank Redemption", "Frank Darabont", "Drama", 1994);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 705, 488);
    contentPane = new JPanel();
    contentPane.setBackground(Color.GRAY);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblNewLabel = new JLabel("Enter a movie");
    lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
    lblNewLabel.setBounds(90, 39, 139, 34);
    contentPane.add(lblNewLabel);

    inputID = new JTextField();
    inputID.setFont(new Font("Dialog", Font.PLAIN, 13));
    inputID.setBounds(102, 82, 139, 20);
    contentPane.add(inputID);
    inputID.setColumns(10);

    inputName = new JTextField();
    inputName.setFont(new Font("Dialog", Font.PLAIN, 13));
    inputName.setColumns(10);
    inputName.setBounds(102, 113, 139, 20);
    contentPane.add(inputName);

    inputDirector = new JTextField();
    inputDirector.setFont(new Font("Dialog", Font.PLAIN, 13));
    inputDirector.setColumns(10);
    inputDirector.setBounds(102, 144, 139, 20);
    contentPane.add(inputDirector);

    inputYear = new JTextField();
    inputYear.setFont(new Font("Dialog", Font.PLAIN, 13));
    inputYear.setColumns(10);
    inputYear.setBounds(102, 175, 139, 20);
    contentPane.add(inputYear);

    JCheckBox inputCbAction = new JCheckBox("Action");
    inputCbAction.setFont(new Font("Dialog", Font.PLAIN, 12));
    inputCbAction.setBackground(Color.LIGHT_GRAY);
    inputCbAction.setBounds(102, 212, 71, 23);
    contentPane.add(inputCbAction);

    JCheckBox inputCbDrama = new JCheckBox("Drama");
    inputCbDrama.setFont(new Font("Dialog", Font.PLAIN, 12));
    inputCbDrama.setBackground(Color.LIGHT_GRAY);
    inputCbDrama.setBounds(175, 212, 66, 23);
    contentPane.add(inputCbDrama);

    JCheckBox inputCbComedy = new JCheckBox("Comedy");
    inputCbComedy.setFont(new Font("Dialog", Font.PLAIN, 12));
    inputCbComedy.setBackground(Color.LIGHT_GRAY);
    inputCbComedy.setBounds(102, 241, 71, 23);
    contentPane.add(inputCbComedy);

    JCheckBox inputCbThriller = new JCheckBox("Thriller");
    inputCbThriller.setFont(new Font("Dialog", Font.PLAIN, 12));
    inputCbThriller.setBackground(Color.LIGHT_GRAY);
    inputCbThriller.setBounds(175, 241, 66, 23);
    contentPane.add(inputCbThriller);

    group.add(inputCbAction);
    group.add(inputCbDrama);
    group.add(inputCbComedy);
    group.add(inputCbThriller);

    JLabel lblNewLabel_1 = new JLabel("ID");
    lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1.setBounds(20, 84, 82, 17);
    contentPane.add(lblNewLabel_1);

    JLabel lblNewLabel_1_1 = new JLabel("Name");
    lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1.setBounds(20, 116, 82, 17);
    contentPane.add(lblNewLabel_1_1);

    JLabel lblNewLabel_1_1_1 = new JLabel("Director");
    lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_1.setBounds(20, 147, 82, 17);
    contentPane.add(lblNewLabel_1_1_1);

    JLabel lblNewLabel_1_1_1_1 = new JLabel("Year");
    lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_1_1.setBounds(20, 178, 82, 17);
    contentPane.add(lblNewLabel_1_1_1_1);

    JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Genre");
    lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_1_1_1_1.setBounds(20, 216, 82, 17);
    contentPane.add(lblNewLabel_1_1_1_1_1_1);

    JButton btnAdd = new JButton("Add movie");
    JTextArea outputLog = new JTextArea();
    outputLog.setText("Hello!");
    outputLog.setWrapStyleWord(true);
    outputLog.setBounds(0, 363, 689, 86);
    contentPane.add(outputLog);
    outputLog.setLineWrap(true);

    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String genreStr = "no genre";
        for (Enumeration < AbstractButton > buttons = group.getElements(); buttons.hasMoreElements();) {
          AbstractButton button = buttons.nextElement();
          if (button.isSelected()) {
            genreStr = button.getText();
            //return button.getText();
          }
        }
        try {
          addFilm(inputID.getText(), inputName.getText(),
            inputDirector.getText(), genreStr, Integer.parseInt(inputYear.getText()));
          logText = outputLog.getText();
          outputLog.setText(logText + "\nA movie with " + inputID.getText() + "is successfully added.");
          outputLog.setForeground(Color.BLACK);
        } catch (Exception e2) {
          logText = outputLog.getText();
          outputLog.setText(logText + "\nPlease enter a valid year");
          outputLog.setForeground(Color.RED);
        }
        if (messageForLog != "") {
          outputLog.setText(logText + "\n" + messageForLog);
          outputLog.setForeground(Color.RED);
        }

        printAll();
      }
    });
    btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnAdd.setBounds(102, 284, 139, 23);
    contentPane.add(btnAdd);

    JPanel panel = new JPanel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setBounds(10, 31, 265, 310);
    contentPane.add(panel);

    sID = new JTextField();
    sID.setEditable(false);
    sID.setFont(new Font("Segoe UI", Font.BOLD, 13));
    sID.setBackground(Color.WHITE);
    sID.setForeground(Color.BLACK);
    sID.setColumns(10);
    sID.setBounds(486, 82, 139, 20);
    contentPane.add(sID);

    sName = new JTextField();
    sName.setEditable(false);
    sName.setFont(new Font("Segoe UI", Font.BOLD, 13));
    sName.setBackground(Color.WHITE);
    sName.setForeground(Color.BLACK);
    sName.setColumns(10);
    sName.setBounds(486, 113, 139, 20);
    contentPane.add(sName);

    sDirector = new JTextField();
    sDirector.setEditable(false);
    sDirector.setFont(new Font("Segoe UI", Font.BOLD, 13));
    sDirector.setBackground(Color.WHITE);
    sDirector.setForeground(Color.BLACK);
    sDirector.setColumns(10);
    sDirector.setBounds(486, 144, 139, 20);
    contentPane.add(sDirector);

    sYear = new JTextField();
    sYear.setEditable(false);
    sYear.setFont(new Font("Segoe UI", Font.BOLD, 13));
    sYear.setBackground(Color.WHITE);
    sYear.setForeground(Color.BLACK);
    sYear.setColumns(10);
    sYear.setBounds(486, 175, 139, 20);
    contentPane.add(sYear);

    JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Year");
    lblNewLabel_1_1_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_1_1_1.setBounds(404, 178, 82, 17);
    contentPane.add(lblNewLabel_1_1_1_1_1);

    JLabel lblNewLabel_1_1_1_2 = new JLabel("Director");
    lblNewLabel_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_1_2.setBounds(404, 147, 82, 17);
    contentPane.add(lblNewLabel_1_1_1_2);

    JLabel lblNewLabel_1_1_2 = new JLabel("Name");
    lblNewLabel_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_2.setBounds(404, 116, 82, 17);
    contentPane.add(lblNewLabel_1_1_2);

    JLabel lblNewLabel_1_2 = new JLabel("ID");
    lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_2.setBounds(404, 84, 82, 17);
    contentPane.add(lblNewLabel_1_2);

    JLabel lblNewLabel_2 = new JLabel("Search for a movie");
    lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 18));
    lblNewLabel_2.setBounds(447, 39, 163, 34);
    contentPane.add(lblNewLabel_2);

    sGenre = new JTextField();
    sGenre.setEditable(false);
    sGenre.setFont(new Font("Segoe UI", Font.BOLD, 13));
    sGenre.setBackground(Color.WHITE);
    sGenre.setForeground(Color.BLACK);
    sGenre.setColumns(10);
    sGenre.setBounds(486, 206, 139, 20);
    contentPane.add(sGenre);

    JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Genre");
    lblNewLabel_1_1_1_1_1_2.setFont(new Font("Dialog", Font.PLAIN, 13));
    lblNewLabel_1_1_1_1_1_2.setBounds(404, 209, 82, 17);
    contentPane.add(lblNewLabel_1_1_1_1_1_2);

    sIDSearch = new JTextField();
    sIDSearch.setFont(new Font("Dialog", Font.PLAIN, 13));
    sIDSearch.setColumns(10);
    sIDSearch.setBounds(486, 256, 139, 20);
    contentPane.add(sIDSearch);

    JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("Find by ID ");
    lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("Dialog", Font.BOLD, 13));
    lblNewLabel_1_1_1_1_1_2_1.setBounds(404, 259, 82, 17);
    contentPane.add(lblNewLabel_1_1_1_1_1_2_1);

    JButton btnSearch = new JButton("Search");
    btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
    btnSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String keyId = sIDSearch.getText();
        System.out.println(keyId);
        int flagFound = 0;
        for (int i = 0; i < filmCounter; i++) {
          // System.out.println("Film counter: " + filmCounter + "obj[i].id: " + obj[i].ID + "key ID: "+keyId );
          if (obj[i].ID.equals(keyId)) {
            sID.setText(obj[i].ID);
            sGenre.setText(obj[i].genre);
            sYear.setText(Integer.toString(obj[i].year));
            sName.setText(obj[i].title);
            sDirector.setText(obj[i].director);
            // outputLog.setText("There is film with that ID");
            logText = outputLog.getText();
            outputLog.setText(logText + "\nThere is film with that ID " + keyId);
            outputLog.setForeground(Color.BLACK);
            flagFound = 1;
          }
        }
        if (flagFound == 0) {
          logText = outputLog.getText();
          outputLog.setText(logText + "\nThere is no film with that ID " + keyId);
          outputLog.setForeground(Color.RED);
        }
      }
    });
    btnSearch.setBounds(486, 284, 139, 23);
    contentPane.add(btnSearch);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.LIGHT_GRAY);
    panel_1.setBounds(392, 31, 265, 310);
    contentPane.add(panel_1);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(654, 451, -599, -86);
    contentPane.add(scrollPane);

    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(447, 404, -126, -52);
    contentPane.add(scrollPane_1);

    JButton btnNewButton = new JButton("New button");
    btnNewButton.setBounds(600, 426, 89, 23);
    contentPane.add(btnNewButton);

    JButton button = new JButton("New button");
    button.setBounds(600, 364, 89, 23);
    contentPane.add(button);

    JButton btnNewButton_1 = new JButton("Clear log");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        outputLog.setText("The log has been cleared!");
        outputLog.setForeground(Color.BLACK);
      }
    });
    btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
    btnNewButton_1.setBounds(0, 0, 89, 23);
    contentPane.add(btnNewButton_1);

  }
}