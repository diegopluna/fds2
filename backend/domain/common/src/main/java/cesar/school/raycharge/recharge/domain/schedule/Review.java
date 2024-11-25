package cesar.school.raycharge.recharge.domain.schedule;

import org.jmolecules.ddd.types.ValueObject;

public class Review implements ValueObject {
    private final ReviewId id;
    private final ReviewScore score;
    private final String comment;

    public Review(ReviewId id, ReviewScore score, String comment) {
        this.id = id;
        this.score = score;
        this.comment = comment;
    }

    public ReviewId getId() {
        return id;
    }

    public ReviewScore getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Review review) {
            return id.equals(review.id);
        }
        return false;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
