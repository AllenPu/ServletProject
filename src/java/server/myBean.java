/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ruizhipu
 */
public class myBean extends Object implements Serializable {

    public static final String ISTATUS = "Login";

    private String status;
    private Date time;
    private int id;
    private String name;

    public myBean() {
        status = ISTATUS;
        id=0;
        name = new String();
        time = null;
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}

    public int getId() {return id;}
    public void setId(int value) {id = value;}

    public String getName() {return name;}
    public void setName(String value) {name = value;}
    
    public Date getDate(){return time;}
    public void setDate(Date date){time = date;}
    
    public List<Integer> getListfromsmalltolarge(List<String> list){
        List<Integer> listint = new ArrayList<Integer>();
        for(String i:list){
            if(i instanceof String){
                int b;
                b = Integer.parseInt(i);
                listint.add(b);
            }
        }
        Collections.sort(listint);
        return listint;
    }

}
