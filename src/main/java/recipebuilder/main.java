package recipebuilder;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
	}
	
	public static void hibernateStuff() {
			
		Session sess = HibernateUtil.getSession();

		Transaction tx = sess.beginTransaction();
		
		Bear parent = new Bear(0, "Orange & Blue", "Grizzley", 1000, 8, null, null, null);
		
		sess.save(ig1);
		
		System.out.println(bp); 
		
		tx.commit();
		
		sess.close();
	}

}