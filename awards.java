package airforce1;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class awards extends JFrame {
	
	// Directory where we've stored the local data files, such as aircraft.owl
    public static final String SOURCE = "./src/main/resources/data/";

    // Places ontology namespace
    public static final String AIRCRAFT = "http://www.semanticweb.org/w10/ontologies/2019/10/untitled-ontology-69#";
    
	private JPanel contentPane;
	
	//private ArrayList<String> arr = new ArrayList<String>();
	
	/****************** Define ScrollPane that will load JTable in it ****************************/
	private JScrollPane sp=new JScrollPane();
	
	/********************************************************************************************/
	
	public static  awards home_frame = new  awards();
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
	public  awards() {
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
	
		JButton btnawards = new JButton("Search Awards");
		btnawards.setBackground(SystemColor.controlHighlight);
		btnawards.setFocusable(false);
		btnawards.setFocusTraversalKeysEnabled(false);
		btnawards.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnawards.setBounds(456, 177, 180, 51);
		btnawards.setFocusPainted(false);
		
		btnawards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String awards = txtByName.getText().toString().toLowerCase();
				//create instance of OntModel class
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				//read ontology model
				FileManager.get().readModel( m, SOURCE + "af.owl" );
				
				String prefix = "prefix ac: <" +  AIRCRAFT + ">\n" +
		                		"prefix rdfs: <" + RDFS.getURI() + ">\n" +
		                		"prefix owl: <" + OWL.getURI() + ">\n";

				String query_text=  prefix +
							" SELECT ?fname ?year  \r\n" + 
						"WHERE{?x a ac:gallentry_award. ?a ac:Award_won_by ?fname. ?a ac:Year ?year \r\n" +
							"FILTER (str(?year)='2012') \r\n" ;
				
				query_text +=	"} ORDER BY ASC(?fname)" ;
			
				
		
				
				System.out.println(query_text);
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		       
		        /*************************************** Create Arrays for Table Headers and Table Values **********************************/ 
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("fname");
		        columns.add("year");
		 
		        
	            /*******************************************************************************************************************************/

		        try {
		            ResultSet results = qexec.execSelect();
		            int i = 0;
		            while ( results.hasNext() ) {
		                QuerySolution qs = results.next();
		               
		                /****************************  Assign query data to array. That will populate JTable **************************/
		                values.add(new String[] {qs.get("fname").toString(), qs.get("year").toString()});
		               /**************************************************************************************************************/
		                
		                System.out.println(qs.get("fname"));
		                i++;
		            }
		            
		         /*************************Create Table and tableModel******************************/
		            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		            JTable table = new JTable(tableModel);
		            table.setForeground(Color.DARK_GRAY);
		            table.setBackground(Color.WHITE);
		            table.setRowHeight(35);		
		            sp.setViewportView(table);		           
		            sp.setBounds(60, 250, 570, 317);
		            contentPane.add(sp);
		            contentPane.repaint();
		          /*********************************************************************************/
		        }
		        finally {
		            qexec.close();
		        }

			}
		});
		contentPane.setLayout(null);
		btnawards.setPreferredSize(new Dimension(350, 45));
		contentPane.add(btnawards);
		
		JLabel lblawards_1 = new JLabel("Awards won by");
		lblawards_1.setForeground(new Color(238, 130, 238));
		lblawards_1.setFont(new Font("Sitka Small", Font.BOLD, 31));
		lblawards_1.setBounds(88, 105, 594, 45);
		contentPane.add(lblawards_1);
		
		txtByName = new JTextField();
		txtByName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtByName.setToolTipText("Enter year");
		txtByName.setBounds(100, 177, 355, 51);
		contentPane.add(txtByName);
		txtByName.setColumns(10);
		
		
	
		
	}
}
