package recipebuilder;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Util.HibernateUtil;
import domains.Ingredient;
import domains.Recipe;
import domains.Review;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		hibernateStuff();
	}
	
	public static void hibernateStuff() {
			
		Session sess = HibernateUtil.getSession();

		Transaction tx = sess.beginTransaction();
		
		Ingredient ig1 = new Ingredient(0, "meat", null);
		Ingredient ig2 = new Ingredient(0, "noodles", null);
		Ingredient ig3 = new Ingredient(0, "pasta sauce", null);
		Ingredient ig4 = new Ingredient(0, "peppers", null);
		Ingredient ig5 = new Ingredient(0, "salt", null);
		Ingredient ig6 = new Ingredient(0, "tuna", null);
		Ingredient ig7 = new Ingredient(0, "chicken", null);
		/*
		sess.save(ig1);
		sess.save(ig2);
		sess.save(ig3);
		sess.save(ig4);
		sess.save(ig5);
		sess.save(ig6);
		sess.save(ig7);
		*/
		
		Set<Ingredient> ins1 = new HashSet<Ingredient>();
		ins1.add(ig2);
		ins1.add(ig3);
		ins1.add(ig5);
		Recipe re1 = new Recipe(0, "Pasta", "Bob", "Bobby", "Boil water, add sause, eat", null, ins1);
		
		sess.save(ig2);
		sess.save(ig3);
		sess.save(ig4);
		
		Review rv1 = new Review(0,"Lee", "Brininger", 3, "Its ok I guess, needs more flavor", re1);
		Review rv2 = new Review(0,"Will", "Jones", 3, "Its ok I guess, needs more flavor", re1);
		Review rv3 = new Review(0,"Nick", "Peters", 3, "Its ok I guess, needs more flavor", re1);
		
		sess.save(rv1);
		sess.save(rv2);
		sess.save(rv3);
		
		tx.commit();
		
		sess.close();
	}

}