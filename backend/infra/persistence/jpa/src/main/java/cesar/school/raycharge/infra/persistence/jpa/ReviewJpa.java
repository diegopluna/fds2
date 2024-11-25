package cesar.school.raycharge.infra.persistence.jpa;

import cesar.school.raycharge.recharge.domain.schedule.ReviewScore;
import jakarta.persistence.*;

@Embeddable
public class ReviewJpa {
    @Enumerated(EnumType.STRING)
    ReviewScore score;

    String comment;

    protected ReviewJpa() {
    }

    public ReviewJpa(ReviewScore score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public ReviewScore getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
