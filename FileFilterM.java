/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package stv;

/**
 *
 * @author bergurth
 */
import java.io.File;
import javax.swing.filechooser.*;
public class FileFilterM extends FileFilter{
    private String ImageFormat = "GIF";
    private char DotIndex = '.';

    private String name;

    public boolean accept(File F)
    {

        if(extension(F).equalsIgnoreCase(ImageFormat))
            {
                return true;
            }

         name = F.getName().toLowerCase();
        return name.endsWith(".gif") || name.endsWith(".jpg")
            || name.endsWith(".jpeg") || name.endsWith(".png")                    || F.isDirectory();

    }
    public String getDescription()
    {
        return "Gif, PNG, JPEG, JPN formats";
    }
    public String extension (File F)
    {
        String FileName = F.getName();
        int IndexFile = FileName.lastIndexOf(DotIndex);
        if(IndexFile > 0 && IndexFile < FileName.length()-1)
            {
                return FileName.substring(IndexFile+1);
            }else
            {
                return " ";
            }
    }

}

