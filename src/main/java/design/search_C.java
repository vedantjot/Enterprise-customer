package design;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.swing.text.TableView.TableCell;

import org.h2.engine.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Model.Form;
import backend.Hypernet;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import design.form_C;
public class search_C {
	
	
	Stage stage;
	
	public void setStage(Stage s)
	{
		stage=s;
	}
	
	
	
	
	@FXML
	private TextField txtName,txtCity,txtNumber;
	@FXML
	private TableView<Form> table;
	@FXML
	private TableColumn<Form, String> clmNumber,clmName,clmCity;
	@FXML
	private TableColumn<Form, Integer> clmID;
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void btnSearch()
	{
		
	
		List resultList = null;
		  try {
			  Session session = Hypernet.getsessionfactory().openSession();
		        session.beginTransaction();
		        
		        Query q=null;
		        
		        
		        if(!(txtName.getText()==null || txtName.getText().trim().isEmpty()))
		        {
		        	
		        	q = session.createQuery("FROM Form WHERE name= :n");
		        	q.setString("n", txtName.getText());
		        }
		        if(!(txtCity.getText()==null || txtCity.getText().trim().isEmpty()))
		        {
		        	
		        	q = session.createQuery("FROM Form WHERE city= :c");
		        	q.setString("c", txtCity.getText());
		        }
		        
		        if(!(txtNumber.getText()==null || txtNumber.getText().trim().isEmpty()))
		        {
		        	
		        	q = session.createQuery("FROM Form WHERE number= :nn");
		        	q.setString("nn", txtNumber.getText());
		        }
		        
		       
		        resultList = q.list();
		       session.getTransaction().commit();
		    } catch (HibernateException he)
		  {
		        he.printStackTrace();
		    }
			
		  List<Form> f =new ArrayList<Form>();
		 for(Object o : resultList) 
		 {
			 Form node=(Form)o;
		       f.add(node);
		      System.out.println(node.getID());
		       
		 }	
		 
		 clmID.setCellValueFactory(new PropertyValueFactory<Form, Integer>("ID"));
			 clmName.setCellValueFactory(new PropertyValueFactory<Form, String>("name"));
			 clmCity.setCellValueFactory(new PropertyValueFactory<Form, String>("city"));
			 clmNumber.setCellValueFactory(new PropertyValueFactory<Form, String>("number"));
			 
			  
			 
			table.getItems().setAll(f);
			
		 }
		Form node=null;
		@SuppressWarnings("unchecked")
		public void display()
		{
			
			TableViewSelectionModel<Form> selectModel = table.getSelectionModel();
			selectModel.setSelectionMode(SelectionMode.SINGLE);
			node = selectModel.getSelectedItem();
			
			stage.close();
			
		}
		
		
		public void displayAll()
		{
			
			System.out.println("ha bhai call thai che");
			List resultList = null;
			  try {
				  Session session = Hypernet.getsessionfactory().openSession();
			        session.beginTransaction();
			        
			        Query q=null;
			        
			        
			        q=session.createQuery("FROM Form");
			        
			       
			        resultList = q.list();
			       session.getTransaction().commit();
			    } catch (HibernateException he)
			  {
			        he.printStackTrace();
			    }
				
			  List<Form> f =new ArrayList<Form>();
			 for(Object o : resultList) 
			 {
				 Form node=(Form)o;
			       f.add(node);
			      
			       
			 }	
			 
			 clmID.setCellValueFactory(new PropertyValueFactory<Form, Integer>("ID"));
				 clmName.setCellValueFactory(new PropertyValueFactory<Form, String>("name"));
				 clmCity.setCellValueFactory(new PropertyValueFactory<Form, String>("city"));
				 clmNumber.setCellValueFactory(new PropertyValueFactory<Form, String>("number"));
				 
				  
				 
				table.getItems().setAll(f);
				
			
			
		}
}
