/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohamedamahmoud
 */
public class Lab7a {
   
    public static void main(String[] args) throws IOException {
        ArrayList<Row> array = new ArrayList<>();
        BufferedReader a = null;
        try {
            FileReader R = new FileReader("sampleCSV.csv");
            a = new BufferedReader(R);
            String line = "";
            line = a.readLine();
            //System.out.println(a.readLine());
            String[]  columnHeadings = line.split(",");
           
            while((line = a.readLine()) != null ){
                String[]  column = line.split(",");
                //System.out.println(line 
                
                Row row  = new Row(column.length);
                for (int j = 0; j < column.length; j++) {
                    row.addColumn(j, column[j]);
                }
                array.add(row);
                
            }
        
            
            

           for(String heading : columnHeadings)
           {
               System.out.println("" + heading);
           }
            
           for(Row r: array)
           {
               System.out.println(r);
           }
          
           
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Lab7a.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("The file is not there");
        } catch (IOException ex) {
            Logger.getLogger(Lab7a.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
               a.close();    
           }
        

    }
    
    
}
class Row{
    private String[] columns;
    
    
    public Row(int numColumns){
        this.columns = new String[numColumns];
    }
    public void addColumn(int column, String value){
        this.columns[column] = value;
    }
    public String toString(){
        String str = "";
        for (int i = 0; i < columns.length; i++) {
            str += columns[i] + ",";
        }
        return str;
    }
    
}
        
    