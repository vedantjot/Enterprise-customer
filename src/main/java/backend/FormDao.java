package backend;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Form;
import backend.*;

public class FormDao {

	public void saveStudent(Form f)
	{
		Transaction transaction =null;
		try(Session session = Hypernet.getsessionfactory().openSession())
		{
			transaction =session.beginTransaction();
			session.save(f);
			System.out.println("yess");
			transaction.commit();
			
		}
		catch(Exception e)
		{
			e.getCause();
			if(transaction != null )
			{
				transaction.rollback();
			}
		}
	}
	
	
	
	
	public Form getStudent(int ID)
	{
		Transaction transaction =null;
		Form f=null;
		try(Session session = Hypernet.getsessionfactory().openSession())
		{
			transaction =session.beginTransaction();
			f=session.get(Form.class, ID);
			
			transaction.commit();
			
		}
		catch(Exception e)
		{
			if(transaction != null )
			{
				transaction.rollback();
			}
		}
		return f;
	}
	
	
	
	public void deleteStudent(int ID)
	{
		Transaction transaction =null;
		Form f=null;
		try(Session session = Hypernet.getsessionfactory().openSession())
		{
			transaction =session.beginTransaction();
			f=session.get(Form.class, ID);
			session.delete(f);
			transaction.commit();
			
		}
		catch(Exception e)
		{
			if(transaction != null )
			{
				transaction.rollback();
			}
		}
		
	}
	
}
