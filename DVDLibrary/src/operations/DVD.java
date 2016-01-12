package operations;

/**
 *
 * @author Suzanne Ludwig && Dessa
 */
public class DVD {
    String title;
    String releaseDate;
    String rating;
    String director;
    String studio;
    String userNote;
    
    public DVD(String title, String releaseDate, String rating, String director, String studio, String userNote){
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.director = director;
        this.studio = studio;
        this.userNote = userNote;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }
    
    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
        
    }
    
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    public String toString() {
        return title + ", " + releaseDate +  "\nRating: " + rating + "\nDirector: " + director + "\nStudio: " + studio + "\nNotes: " + userNote + " ";
    }

    public String saveString() {
        return title + "::" + releaseDate + "::" + rating + "::" + director + "::" + studio + "::" + userNote;
                
    }

}
