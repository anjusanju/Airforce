package airforce1;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class SearchAirperson extends JFrame {
	
	// Directory where we've stored the local data files, such as places.owl
    public static final String SOURCE = "./src/main/resources/data/";

    // Places ontology namespace
    public static final String AIRCRAFT = "http://www.semanticweb.org/w10/ontologies/2019/10/untitled-ontology-69#";
    
	private JPanel contentPane;
	
	//private ArrayList<String> arr = new ArrayList<String>();
	
    DefaultListModel listModel = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	
	public static SearchAirperson home_frame = new SearchAirperson();
	private JTextField txtByName;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchAirperson() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Arial", Font.PLAIN, 14));
	
		setTitle("Semantic Search");
		setResizable(false);
		setPreferredSize(new Dimension(800, 800));
		setMaximumSize(new Dimension(800, 800));
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(700, 700));
		contentPane.setMaximumSize(new Dimension(400, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton btnSearchAirperson= new JButton("Search");
		btnSearchAirperson.setBackground(SystemColor.controlHighlight);
		btnSearchAirperson.setFocusable(false);
		btnSearchAirperson.setFocusTraversalKeysEnabled(false);
		btnSearchAirperson.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchAirperson.setBounds(456, 177, 140, 51);
		btnSearchAirperson.setFocusPainted(false);
		btnSearchAirperson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtByName.getText().toString().toLowerCase();
				//create instance of OntModel class
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				//read ontology model
				FileManager.get().readModel( m, SOURCE + "af.owl" );
				
				String prefix = "prefix ac: <" + AIRCRAFT + ">\n" +
		                		"prefix rdfs: <" + RDFS.getURI() + ">\n" +
		                		"prefix owl: <" + OWL.getURI() + ">\n";

				String query_text=  prefix +
							"select ?name where {?airperson a ac:Air_person. " +
							"                     ?airperson ac:Fname ?name. " +
							 " ?airperson  ac:Lname ?Lastname." + 
							" ?airperson  ac:AID ?aid.\n\r";
				
				if(name != null && !name.isEmpty()) {
						query_text += "FILTER(regex(str(?name),\""+name+"\",\"i\")) ";
				}
				query_text +=	"}" ; 
				System.out.println(query_text);
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		    	
		        listModel.removeAllElements();
		        try {
		            ResultSet results = qexec.execSelect();
		            int i = 0;
		            while ( results.hasNext() ) {
		                QuerySolution qs = results.next();
		               // arr.add(qs.get("name").toString());
		                listModel.addElement(qs.get("name").toString());
		                System.out.println(qs.get("name"));
		                i++;
		            }
		          if(i == 0) {
		        	  listModel.addElement("There was no match found for '"+name+"'");
		          }
		          
		            //Create List
		    		JList list = new JList();
		    		list.setForeground(Color.DARK_GRAY);
		    		list.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		    		list.setBackground(Color.WHITE);
		    		list.setBounds(60, 250, 570, 317);
		    		list.setModel(listModel);
		    		list.setSelectedIndex(-1);
		            contentPane.add(list);
		            contentPane.repaint();
		        }
		        finally {
		            qexec.close();
		        }

			}
		});
		contentPane.setLayout(null);
		btnSearchAirperson.setPreferredSize(new Dimension(350, 45));
		contentPane.add(btnSearchAirperson);
		
		JLabel lblPeople_1 = new JLabel("SEARCH AIRPERSON");
		lblPeople_1.setForeground(new Color(238, 130, 238));
		lblPeople_1.setFont(new Font("Times New Roaman", Font.ITALIC, 20));
		lblPeople_1.setBounds(212, 106, 238, 45);
		contentPane.add(lblPeople_1);
		
		txtByName = new JTextField();
		txtByName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtByName.setToolTipText("Enter Name");
		txtByName.setBounds(100, 177, 355, 51);
		contentPane.add(txtByName);
		txtByName.setColumns(10);
		
		
	
		
	}
}
