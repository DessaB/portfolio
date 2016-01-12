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
public interface DVDLibraryInterface {

    public void add(DVD a);

    public void remove(DVD a);

    public DVD find(String a);

    public int findTitleNum(String a);

    public ArrayList<DVD> getAll();

    public void findByYear();

    public void findByMpaa();

    public void findByDirector();

    public void findByStudio();

    public void averageAge();

    public void newestMovie();

    public void oldestMovie();

}
