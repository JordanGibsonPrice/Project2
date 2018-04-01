package domains;

import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECIPE")
public class Recipe {
	
	@Id
	@Column(name = "RECIPE_ID")
	@SequenceGenerator(name="RECIPE_ID_SEQ", sequenceName="RECIPE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECIPE_ID_SEQ")
	private int recipeId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CREATOR_First_Name")
	private String creatorFirstName;
	
	@Column(name="CREATOR_LAST_NAME")
	private String creatorLastName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.MERGE, mappedBy="recipeReviewed")
	private Set<Review> reviews = new HashSet<Review>();
	

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="RECIPE_INGREDIENT",
				joinColumns=@JoinColumn(name="INGREDIENT_ID"),
				inverseJoinColumns=@JoinColumn(name="RECIPE_ID"))
	private Set<Ingredient> ingredients;


	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(int recipeId, String name, String creatorFirstName, String creatorLastName, String description,
			Set<Review> reviews, Set<Ingredient> ingredients) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.creatorFirstName = creatorFirstName;
		this.creatorLastName = creatorLastName;
		this.description = description;
		this.reviews = reviews;
		this.ingredients = ingredients;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creatorFirstName == null) ? 0 : creatorFirstName.hashCode());
		result = prime * result + ((creatorLastName == null) ? 0 : creatorLastName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + recipeId;
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		Recipe other = (Recipe) obj;
		if (creatorFirstName == null) {
			if (other.creatorFirstName != null)
				return false;
		} else if (!creatorFirstName.equals(other.creatorFirstName))
			return false;
		if (creatorLastName == null) {
			if (other.creatorLastName != null)
				return false;
		} else if (!creatorLastName.equals(other.creatorLastName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipeId != other.recipeId)
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}

	public int getRecipeId() {
		return recipeId;
	}


	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getCreatorFirstName() {
		return creatorFirstName;
	}

	public void setCreatorFirstName(String creatorFirstName) {
		this.creatorFirstName = creatorFirstName;
	}

	public String getCreatorLastName() {
		return creatorLastName;
	}

	public void setCreatorLastName(String creatorLastName) {
		this.creatorLastName = creatorLastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
