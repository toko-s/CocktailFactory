package filter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CocktailFilter {
    private String name;

    private Double rating;

    private Rating ratingType;

    CocktailFilter(String name, Double rating, Rating ratingType) {
        this.name = name;
        this.rating = rating;
        this.ratingType = ratingType;
    }

    public static CocktailFilterBuilder builder() {
        return new CocktailFilterBuilder();
    }

    public String getName() {
        return this.name;
    }

    public Double getRating() {
        return this.rating;
    }

    public Rating getRatingType() {
        return this.ratingType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setRatingType(Rating ratingType) {
        this.ratingType = ratingType;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CocktailFilter)) return false;
        final CocktailFilter other = (CocktailFilter) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$rating = this.getRating();
        final Object other$rating = other.getRating();
        if (this$rating == null ? other$rating != null : !this$rating.equals(other$rating)) return false;
        final Object this$ratingType = this.getRatingType();
        final Object other$ratingType = other.getRatingType();
        if (this$ratingType == null ? other$ratingType != null : !this$ratingType.equals(other$ratingType))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CocktailFilter;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $rating = this.getRating();
        result = result * PRIME + ($rating == null ? 43 : $rating.hashCode());
        final Object $ratingType = this.getRatingType();
        result = result * PRIME + ($ratingType == null ? 43 : $ratingType.hashCode());
        return result;
    }

    public String toString() {
        return "CocktailFilter(name=" + this.getName() + ", rating=" + this.getRating() + ", ratingType=" + this.getRatingType() + ")";
    }

    public enum Rating{
        HIGHER,
        LOWER
    }

    public static class CocktailFilterBuilder {
        private String name;
        private Double rating;
        private Rating ratingType;

        CocktailFilterBuilder() {
        }

        public CocktailFilterBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CocktailFilterBuilder rating(String rating) {
            try {
                this.rating = Double.parseDouble(rating);
            }
            catch (Exception e){
                this.rating = null;
            }
            return this;
        }

        public CocktailFilterBuilder ratingType(String type) {
            try {
                if (type.equals("LOWER"))
                    this.ratingType = Rating.LOWER;
                else
                    this.ratingType = Rating.HIGHER;
            } catch (Exception e) {
                this.ratingType = null;
            }
            return this;
        }

        public CocktailFilter build() {
            return new CocktailFilter(name, rating, ratingType);
        }

        public String toString() {
            return "CocktailFilter.CocktailFilterBuilder(name=" + this.name + ", rating=" + this.rating + ", ratingType=" + this.ratingType + ")";
        }
    }
}
