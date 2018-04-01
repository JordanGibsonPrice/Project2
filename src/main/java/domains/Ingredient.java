package domains;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INGREDIENT")
public class Ingredient {
	
	@Id
	@Column(name= "INGREDIENT_ID")
	@SequenceGenerator(name="INGREDIENT_ID_SEQ", sequenceName="INGREDIENT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGREDIENT_ID_SEQ")
	private int ingredientId;
	
	@Column(name="NAME")
	private String name;


	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="RECIPE_INGREDIENT",
				joinColumns=@JoinColumn(name="RECIPE_ID"),
				inverseJoinColumns=@JoinColumn(name="INGREDIENT_ID"))
	private Set<Recipe> recipes;

	
	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ingredient(int ingredientId, String name, Set<Recipe> recipes) {
		super();
		this.ingredientId = ingredientId;
		this.name = name;
		this.recipes = recipes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredientId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (ingredientId != other.ingredientId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}


	public int getIngredientId() {
		return ingredientId;
	}


	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Recipe> getRecipes() {
		return recipes;
	}


	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

}
