/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlambdas.operations;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class DVD {

    private String title;
    private String year;
    private String rating;
    private String dirName;
    private String userNote;
    private String runtime;
    private String studio;
    private String mpaa;

    public DVD(String title, String year, String rating, String dirName,
            String userNote, String runtime, String studio, String mpaa) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.dirName = dirName;
        this.userNote = userNote;
        this.runtime = runtime;
        this.studio = studio;
        this.mpaa = mpaa;

    }
    
    public String toString(){
        return title + "\n" + "Year: " + year + "\n" + "Rating: " + rating + "\n"+ "Director: " + dirName + "\n" + "User's note: " + userNote + "\n" +"Run time: " + runtime +"\n"
                + "Studio: " + studio +"\n" + "MPAA: " + mpaa;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the mpaa
     */
    public String getMpaa() {
        return mpaa;
    }

    /**
     * @param mpaa the mpaa to set
     */
    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

}

