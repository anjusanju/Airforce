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
public class SearchAircraft extends JFrame {
	
	// Directory where we've stored the local data files, such as aircraft.owl
    public static final String SOURCE = "./src/main/resources/data/";

    // Ontology namespace
    public static final String AIRCRAFT = "http://www.semanticweb.org/w10/ontologies/2019/10/untitled-ontology-69#";
    
	private JPanel contentPane;
	
	//private ArrayList<String> arr = new ArrayList<String>();
	
	/****************** Define ScrollPane that will load JTable in it ****************************/
	private JScrollPane sp=new JScrollPane();
	
	/********************************************************************************************/
	
	public static  SearchAircraft home_frame = new  SearchAircraft();
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
	public  SearchAircraft() {
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
	
		JButton btnSearchAircraft = new JButton("Search");
		btnSearchAircraft.setBackground(SystemColor.controlHighlight);
		btnSearchAircraft.setFocusable(false);
		btnSearchAircraft.setFocusTraversalKeysEnabled(false);
		btnSearchAircraft.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchAircraft.setBounds(456, 177, 140, 51);
		btnSearchAircraft.setFocusPainted(false);
		
		btnSearchAircraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AIRCRAFTt = txtByName.getText().toString().toLowerCase();
				//create instance of OntModel class
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				
				//read ontology model
				FileManager.get().readModel( m, SOURCE + "af.owl" );
				
				String prefix = "prefix ac: <" +  AIRCRAFT + ">\n" +
		                		"prefix rdfs: <" + RDFS.getURI() + ">\n" +
		                		"prefix owl: <" + OWL.getURI() + ">\n";

				String query_text=  prefix +
							" SELECT ?name  ?speed ?height\r\n" + 
						"WHERE{?a a ac:Aircraft.?a ac:aircraft_name ?name. ?a ac:aircraft_speed ?speed. ?a ac:aircraft_height ?height \r\n}" ;

							System.out.println(query_text);
				
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		       
		        /*************************************** Create Arrays for Table Headers and Table Values **********************************/ 
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();

		        columns.add("Aircraft Name");
		        columns.add("Height");
		        columns.add("Speed");
		        
	            /*******************************************************************************************************************************/

		        try {
		            ResultSet results = qexec.execSelect();
		            int i = 0;
		            while ( results.hasNext() ) {
		                QuerySolution qs = results.next();
		               
		                /****************************  Assign query data to array. That will populate JTable **************************/
		                values.add(new String[] {qs.get("name").toString(), qs.get("speed").toString(),qs.get("height").toString()});
		               /**************************************************************************************************************/
		                
		                System.out.println(qs.get("name"));
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
		btnSearchAircraft.setPreferredSize(new Dimension(350, 45));
		contentPane.add(btnSearchAircraft);
		
		JLabel lblAircraft_1 = new JLabel("Search Aircraft By Name");
		lblAircraft_1.setForeground(new Color(238, 130, 238));
		lblAircraft_1.setFont(new Font("Sitka Small", Font.BOLD, 31));
		lblAircraft_1.setBounds(88, 105, 594, 45);
		contentPane.add(lblAircraft_1);
		
		txtByName = new JTextField();
		txtByName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtByName.setToolTipText("Enter Name");
		txtByName.setBounds(100, 177, 355, 51);
		contentPane.add(txtByName);
		txtByName.setColumns(10);
		
		
	
		
	}
}
