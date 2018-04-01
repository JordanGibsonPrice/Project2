package domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REVIEW")
public class Review {
	
	@Id
	@Column(name="REVIEW_ID")
	@SequenceGenerator(name="REVIEW_ID_SEQ", sequenceName="REVIEW_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REVIEW_ID_SEQ")
	private int reviewId;
	
	@Column(name="AUTHOR_FIRST_NAME")
	private String authorFirstName;
	
	@Column(name="AUTHOR_LAST_NAME")
	private String authorLastName;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="MESSAGE")
	private String message;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="RECIPE_REVIEWED")
	private Recipe recipeReviewed;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewId, String authorFirstName, String authorLastName, int score, String message,
			Recipe recipeReviewed) {
		super();
		this.reviewId = reviewId;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.score = score;
		this.message = message;
		this.recipeReviewed = recipeReviewed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorFirstName == null) ? 0 : authorFirstName.hashCode());
		result = prime * result + ((authorLastName == null) ? 0 : authorLastName.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((recipeReviewed == null) ? 0 : recipeReviewed.hashCode());
		result = prime * result + reviewId;
		result = prime * result + score;
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
		Review other = (Review) obj;
		if (authorFirstName == null) {
			if (other.authorFirstName != null)
				return false;
		} else if (!authorFirstName.equals(other.authorFirstName))
			return false;
		if (authorLastName == null) {
			if (other.authorLastName != null)
				return false;
		} else if (!authorLastName.equals(other.authorLastName))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (recipeReviewed == null) {
			if (other.recipeReviewed != null)
				return false;
		} else if (!recipeReviewed.equals(other.recipeReviewed))
			return false;
		if (reviewId != other.reviewId)
			return false;
		if (score != other.score)
			return false;
		return true;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Recipe getRecipeReviewed() {
		return recipeReviewed;
	}

	public void setRecipeReviewed(Recipe recipeReviewed) {
		this.recipeReviewed = recipeReviewed;
	}

}
